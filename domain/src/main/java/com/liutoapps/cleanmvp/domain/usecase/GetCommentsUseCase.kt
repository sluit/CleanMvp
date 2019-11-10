package com.liutoapps.cleanmvp.domain.usecase

import com.liutoapps.cleanmvp.domain.model.Comment
import com.liutoapps.cleanmvp.domain.repository.CommentRepository
import io.reactivex.Single
import javax.inject.Inject

class GetCommentsUseCase @Inject constructor(
    private val commentRepository: CommentRepository
) {

    companion object {
        private const val MAX_NUMBER_OF_COMMENTS = 20
    }

    fun get(postId: Int): Single<List<Comment>> =
        commentRepository.getComments(postId).map { it.take(MAX_NUMBER_OF_COMMENTS) }
}