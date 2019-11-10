package com.liutoapps.cleanmvp.presentation.ui.photodetail

import com.liutoapps.cleanmvp.presentation.model.CommentItem
import com.liutoapps.cleanmvp.presentation.model.PhotoItem
import com.liutoapps.cleanmvp.presentation.ui.base.BasePresenter

interface PhotoDetailContract {

    interface View {

        fun showPhotoDetails(photo: PhotoItem)

        fun showComments(commentList: List<CommentItem>)

        fun closeDetails()

        fun stopRefresh()

    }

    interface Presenter : BasePresenter<View> {

        fun setPhotoDetails(photo: PhotoItem)

        fun refreshComments()

        fun backPressed(): Boolean

    }

}

