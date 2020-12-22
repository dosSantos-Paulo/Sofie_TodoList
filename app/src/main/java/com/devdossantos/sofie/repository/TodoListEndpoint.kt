package com.devdossantos.sofie.repository

import com.devdossantos.sofie.model.Post
import com.devdossantos.sofie.model.PostResponse
import com.devdossantos.sofie.model.ResponseModel
import com.devdossantos.sofie.utils.NetworkUtils
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface TodoListEndpoint {
    @GET("task")
    suspend fun getList(
        @Query("email") email: String = "paulo.dossantos@hotmail.com"
    ): ResponseModel

    @POST("task")
    suspend fun postNewTodo(
        @Body post: Post
    ): PostResponse

    companion object {
        val Endpoint: TodoListEndpoint by lazy {
            NetworkUtils.getRetrofit().create(TodoListEndpoint::class.java)
        }
    }
}