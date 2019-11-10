package com.liutoapps.cleanmvp.domain.repository

import com.liutoapps.cleanmvp.domain.model.Comment
import io.reactivex.Single

interface CommentRepository {
    fun getComments(photoId: Int): Single<List<Comment>>
}