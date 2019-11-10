package com.liutoapps.cleanmvp.data.remote

import com.liutoapps.cleanmvp.data.entity.CommentEntity
import com.liutoapps.cleanmvp.data.entity.PhotoEntity
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface PhotosApi {

    @GET("photos")
    fun getPhotos(): Single<List<PhotoEntity>>

}

interface CommentsApi {

    @GET("photos/{photoId}/comments")
    fun getComments(@Path("photoId") photoId: Int): Single<List<CommentEntity>>

}