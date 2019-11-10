package com.liutoapps.cleanmvp.data.mapper

import com.liutoapps.cleanmvp.data.entity.PhotoEntity
import com.liutoapps.cleanmvp.domain.model.Photo
import javax.inject.Inject

class PhotoEntityMapper @Inject constructor() {

    fun mapToDomain(entities: List<PhotoEntity>): List<Photo> =
        entities.mapNotNull(::safeMapToDomain)

    private fun safeMapToDomain(entity: PhotoEntity) = try {
        mapToDomain(entity)
    } catch (e: Exception) {
        null
    }

    private fun mapToDomain(entity: PhotoEntity): Photo = Photo(
        requireNotNull(entity.albumId) { "albumId" },
        requireNotNull(entity.id) { "id" },
        requireNotNull(entity.title) { "title" },
        requireNotNull(entity.url) { "url" },
        requireNotNull(entity.thumbnailUrl) { "thumbnailUrl" }
    )

}