package com.liutoapps.cleanmvp.data.entity

import com.squareup.moshi.Json

data class CommentEntity(@Json(name = "postId") val postId: Int,
                       @Json(name = "id") val id: Int,
                       @Json(name = "name") val name: String,
                       @Json(name = "email") val email: String,
                       @Json(name = "body") val body: String)