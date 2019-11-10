package com.liutoapps.cleanmvp.presentation.model

data class CommentItem(val postId: Int,
                       val id: Int,
                       val name: String,
                       val email: String,
                       val body: String)