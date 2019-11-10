package com.liutoapps.cleanmvp.data.repository

import com.liutoapps.cleanmvp.data.mapper.PhotoEntityMapper
import com.liutoapps.cleanmvp.data.remote.PhotosApi
import com.liutoapps.cleanmvp.domain.model.Photo
import com.liutoapps.cleanmvp.domain.repository.PhotoRepository
import io.reactivex.Single
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PhotoRepositoryImpl @Inject constructor(
    private val api: PhotosApi,
    private val mapper: PhotoEntityMapper
) : PhotoRepository {

    override fun getPhotos(): Single<List<Photo>> = api.getPhotos().map(mapper::mapToDomain)

}