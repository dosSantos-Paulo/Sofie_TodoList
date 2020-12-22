package com.devdossantos.sofie.repository

import com.devdossantos.sofie.model.TodoModel
import com.devdossantos.sofie.utils.NetworkUtils
import retrofit2.http.GET

interface TodoListEndpoint {
    @GET
    suspend fun getList(): List<TodoModel>

    companion object {
        val Endpoint: TodoListEndpoint by lazy {
            NetworkUtils.getRetrofit().create(TodoListEndpoint::class.java)
        }
    }
}