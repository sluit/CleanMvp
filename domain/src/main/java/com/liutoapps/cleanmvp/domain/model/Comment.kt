package com.liutoapps.cleanmvp.domain.model

data class Comment(val postId: Int,
                   val id: Int,
                   val name: String,
                   val email: String,
                   val body: String)