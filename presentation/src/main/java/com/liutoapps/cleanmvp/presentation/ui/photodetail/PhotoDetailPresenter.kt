package com.liutoapps.cleanmvp.presentation.ui.photodetail

import android.util.Log
import com.liutoapps.cleanmvp.domain.usecase.GetCommentsUseCase
import com.liutoapps.cleanmvp.presentation.injector.Injector
import com.liutoapps.cleanmvp.presentation.mapper.CommentItemMapper
import com.liutoapps.cleanmvp.presentation.model.PhotoItem
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class PhotoDetailPresenter : PhotoDetailContract.Presenter {

    @Inject
    lateinit var getCommentsUseCase: GetCommentsUseCase

    @Inject
    lateinit var commentItemMapper: CommentItemMapper

    private var view: PhotoDetailContract.View? = null

    private val compositeDisposable = CompositeDisposable()

    private var photoItem: PhotoItem? = null

    override fun onAttach(view: PhotoDetailContract.View) {
        Injector.appComponent.inject(this)
        this.view = view
    }

    override fun onDetatch() {
        compositeDisposable.dispose()
        view = null
    }

    override fun setPhotoDetails(photo: PhotoItem) {
        photoItem = photo
        view?.showPhotoDetails(photo)
        getComments()
    }

    private fun getComments() {
        photoItem?.let {photo ->
            compositeDisposable.add(
                getCommentsUseCase.get(photo.id)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .map { commentItemMapper.mapToPresentation(it) }
                    .subscribe({ view?.showComments(it)},
                        { t: Throwable? ->
                            Log.e("TAG", "error", t)
                        })
            )
        }

    }

    override fun backPressed(): Boolean {
        view?.let {
            it.closeDetails()
            return true
        } ?: return false
    }
}