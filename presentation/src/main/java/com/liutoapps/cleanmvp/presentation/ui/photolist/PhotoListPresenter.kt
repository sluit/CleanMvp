package com.liutoapps.cleanmvp.presentation.ui.photolist

import android.util.Log
import com.liutoapps.cleanmvp.domain.usecase.GetPhotosUseCase
import com.liutoapps.cleanmvp.presentation.injector.Injector
import com.liutoapps.cleanmvp.presentation.mapper.PhotoItemMapper
import com.liutoapps.cleanmvp.presentation.model.PhotoItem
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import timber.log.Timber
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
        view.showLoading(true)
        loadData()
    }

    private fun loadData() {
        compositeDisposable.add(
            getPhotosUseCase.get()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .map { photoListMapper.mapToPresentation(it) }
                .subscribe({
                    view?.showLoading(false)
                    view?.stopRefresh()
                    view?.showList(it)
                },
                    { t: Throwable? ->
                        view?.showLoading(false)
                        view?.stopRefresh()
                        view?.showError()
                        Timber.e(t, "Something went wrong downloading the photos")
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

    override fun refresh() {
        loadData()
    }

}