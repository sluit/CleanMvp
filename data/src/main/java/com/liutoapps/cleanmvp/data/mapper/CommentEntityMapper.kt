package com.liutoapps.cleanmvp.data.mapper

import com.liutoapps.cleanmvp.data.entity.CommentEntity
import com.liutoapps.cleanmvp.domain.model.Comment
import javax.inject.Inject

class CommentEntityMapper @Inject constructor() {

    fun mapToDomain(entities: List<CommentEntity>): List<Comment> =
        entities.mapNotNull(::safeMapToDomain)

    private fun safeMapToDomain(entity: CommentEntity) = try {
        mapToDomain(entity)
    } catch (e: Exception) {
        null
    }

    private fun mapToDomain(entity: CommentEntity): Comment = Comment(
        requireNotNull(entity.postId) { "postId" },
        requireNotNull(entity.id) { "id" },
        requireNotNull(entity.name) { "name" },
        requireNotNull(entity.email) { "email" },
        requireNotNull(entity.body) { "body" }
    )

}