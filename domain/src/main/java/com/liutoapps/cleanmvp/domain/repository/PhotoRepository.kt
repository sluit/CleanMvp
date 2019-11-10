package com.liutoapps.cleanmvp.domain.repository

import com.liutoapps.cleanmvp.domain.model.Photo
import io.reactivex.Single

interface PhotoRepository {
    fun getPhotos(): Single<List<Photo>>
}