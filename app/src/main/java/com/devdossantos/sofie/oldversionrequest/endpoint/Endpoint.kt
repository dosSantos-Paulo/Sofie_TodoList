package com.devdossantos.sofie.oldversionrequest.endpoint

import com.devdossantos.sofie.model.get.ResponseModel
import com.devdossantos.sofie.model.post.Post
import com.devdossantos.sofie.model.post.PostResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface Endpoint {

    @GET("task")
    fun getTodoList(@Query("email") email: String) : Call<ResponseModel>

    @POST("task")
    fun postNewTodo(@Body post: Post): Call<PostResponse>

}