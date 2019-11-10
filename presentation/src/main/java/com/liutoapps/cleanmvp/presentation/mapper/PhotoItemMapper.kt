package com.liutoapps.cleanmvp.presentation.mapper

import com.liutoapps.cleanmvp.domain.model.Photo
import com.liutoapps.cleanmvp.presentation.model.PhotoItem
import javax.inject.Inject

class PhotoItemMapper @Inject constructor() {

    fun mapToPresentation(photo: Photo) : PhotoItem = PhotoItem(photo.albumId, photo.id, photo.title, photo.url, photo.thumbnailUrl)

    fun mapToPresentation(photoList: List<Photo>) : List<PhotoItem> = photoList.map(::mapToPresentation)

}