package com.devdossantos.sofie.oldversionrequest.post

import com.devdossantos.sofie.model.post.PostResponse

interface IPost {
    fun postTodo (post: PostResponse)
}
