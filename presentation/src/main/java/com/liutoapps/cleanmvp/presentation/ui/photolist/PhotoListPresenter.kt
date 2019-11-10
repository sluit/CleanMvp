package com.liutoapps.cleanmvp.presentation.ui.photolist

import android.util.Log
import com.liutoapps.cleanmvp.domain.usecase.GetPhotosUseCase
import com.liutoapps.cleanmvp.presentation.injector.Injector
import com.liutoapps.cleanmvp.presentation.mapper.PhotoItemMapper
import com.liutoapps.cleanmvp.presentation.model.PhotoItem
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class PhotoListPresenter : PhotoListContract.Presenter {

    @Inject
    lateinit var getPhotosUseCase: GetPhotosUseCase

    @Inject
    lateinit var photoListMapper: PhotoItemMapper

    private var view: PhotoListContract.View? = null

    private val compositeDisposable = CompositeDisposable()

    override fun onAttach(view: PhotoListContract.View) {
        Injector.appComponent.inject(this)
        this.view = view
        view.setLoading(true)
        compositeDisposable.add(
            getPhotosUseCase.get()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .map { photoListMapper.mapToPresentation(it) }
                .subscribe({
                    view.setLoading(false)
                    view.showList(it)
                },
                    { t: Throwable? ->
                        view.setLoading(false)
                        Log.e("TAG", "error", t)
                    })
        )
    }

    override fun onDetatch() {
        compositeDisposable.dispose()
        view = null
    }

    override fun clickedPhotoItem(photoItem: PhotoItem) {
        view?.navigateToDetails(photoItem)
    }

}