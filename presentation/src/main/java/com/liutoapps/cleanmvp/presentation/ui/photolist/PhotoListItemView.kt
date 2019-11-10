package com.liutoapps.cleanmvp.presentation.ui.photolist

import android.content.Context
import android.util.AttributeSet
import android.view.View
import androidx.constraintlayout.widget.ConstraintLayout
import com.bumptech.glide.Glide
import com.liutoapps.cleanmvp.presentation.model.PhotoItem
import kotlinx.android.synthetic.main.list_item_photo.view.*

class PhotoListItemView @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0) :
    ConstraintLayout(context, attrs, defStyleAttr) {

    fun setData(item: PhotoItem, clickListener: OnPhotoClickListener) {
        Glide.with(this).load(item.thumbnailUrl).into(item_photo_thumbnail)
        item_photo_title.text = item.title
        setOnClickListener {
            clickListener.onPhotoItemClicked(photoItem = item)
        }
    }

    interface OnPhotoClickListener {

        fun onPhotoItemClicked(photoItem: PhotoItem)

    }

}