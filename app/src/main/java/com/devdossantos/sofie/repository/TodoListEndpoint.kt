package com.devdossantos.sofie.repository

import com.devdossantos.sofie.model.ResponseModel
import com.devdossantos.sofie.model.TodoModel
import com.devdossantos.sofie.utils.NetworkUtils
import retrofit2.http.GET
import retrofit2.http.Query

interface TodoListEndpoint {
    @GET("task")
    suspend fun getList(@Query("email") email: String = "sofie@sofie.com"): ResponseModel

    companion object {
        val Endpoint: TodoListEndpoint by lazy {
            NetworkUtils.getRetrofit().create(TodoListEndpoint::class.java)
        }
    }
}