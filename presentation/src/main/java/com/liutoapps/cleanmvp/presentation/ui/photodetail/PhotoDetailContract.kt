package com.liutoapps.cleanmvp.presentation.ui.photodetail

import com.liutoapps.cleanmvp.presentation.model.CommentItem
import com.liutoapps.cleanmvp.presentation.model.PhotoItem
import com.liutoapps.cleanmvp.presentation.ui.base.BasePresenter

interface PhotoDetailContract {

    interface View {

        fun showPhotoDetails(photo: PhotoItem)

        fun showComments(commentList: List<CommentItem>)

        fun closeDetails()

    }

    interface Presenter : BasePresenter<View> {

        fun setPhotoDetails(photo: PhotoItem)

        fun backPressed(): Boolean

    }

}

