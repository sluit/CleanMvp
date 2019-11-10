package com.liutoapps.cleanmvp.presentation.mapper

import com.liutoapps.cleanmvp.domain.model.Comment
import com.liutoapps.cleanmvp.domain.model.Photo
import com.liutoapps.cleanmvp.presentation.model.CommentItem
import com.liutoapps.cleanmvp.presentation.model.PhotoItem
import javax.inject.Inject

class CommentItemMapper @Inject constructor() {

    fun mapToPresentation(comment: Comment): CommentItem =
        CommentItem(comment.postId, comment.id, comment.name, comment.email, comment.body)

    fun mapToPresentation(commentList: List<Comment>): List<CommentItem> =
        commentList.map(::mapToPresentation)

}