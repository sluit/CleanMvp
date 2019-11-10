package com.liutoapps.cleanmvp.presentation.ui.photodetail

import android.content.Context
import android.util.AttributeSet
import androidx.constraintlayout.widget.ConstraintLayout
import com.liutoapps.cleanmvp.presentation.model.CommentItem
import kotlinx.android.synthetic.main.list_item_comment.view.*

class PhotoDetailCommentItemView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) :
    ConstraintLayout(context, attrs, defStyleAttr) {

    fun setData(item: CommentItem) {
        item_comment_name.text = item.name
        item_comment_email.text = item.email
        item_comment_body.text = item.body
    }

}