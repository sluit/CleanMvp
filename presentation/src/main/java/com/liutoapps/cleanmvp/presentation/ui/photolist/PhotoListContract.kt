package com.liutoapps.cleanmvp.presentation.ui.photolist

import com.liutoapps.cleanmvp.presentation.model.PhotoItem
import com.liutoapps.cleanmvp.presentation.ui.base.BasePresenter

interface PhotoListContract {

    interface View {

        fun showList(photoList: List<PhotoItem>)

    }

    interface Presenter : BasePresenter<View>

}

