package com.liutoapps.cleanmvp.data.remote

import com.liutoapps.cleanmvp.data.entity.PhotoEntity
import io.reactivex.Single
import retrofit2.http.GET

interface PhotosApi {

    @GET("photos")
    fun getPhotos(): Single<List<PhotoEntity>>

}