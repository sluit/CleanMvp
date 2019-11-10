package com.liutoapps.cleanmvp.data.repository

import com.liutoapps.cleanmvp.data.mapper.CommentEntityMapper
import com.liutoapps.cleanmvp.data.remote.CommentsApi
import com.liutoapps.cleanmvp.domain.model.Comment
import com.liutoapps.cleanmvp.domain.repository.CommentRepository
import io.reactivex.Single
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CommentRepositoryImpl @Inject constructor(
    private val api: CommentsApi,
    private val mapper: CommentEntityMapper
) : CommentRepository {

    override fun getComments(photoId: Int): Single<List<Comment>> =
        api.getComments(photoId).map(mapper::mapToDomain)

}