package com.devdossantos.sofie.repository

import com.devdossantos.sofie.model.post.Post

class TodoRepository {
    private val client = TodoListEndpoint.Endpoint

    suspend fun getList() = client.getList()

    suspend fun postNewTodo(post: Post) = client.postNewTodo(post)
}