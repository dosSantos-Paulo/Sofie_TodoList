package com.devdossantos.sofie.oldversionrequest.post

import android.content.Context
import android.widget.Toast
import com.devdossantos.sofie.model.post.Post
import com.devdossantos.sofie.model.post.PostResponse
import com.devdossantos.sofie.oldversionrequest.endpoint.Endpoint
import com.devdossantos.sofie.utils.NetworkUtils
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PostApi {

    companion object {
        fun postData(post: Post, context: Context, IPost: IPost) {
            val retrofitClient = NetworkUtils.getRetrofit()

            val endpoint = retrofitClient.create(Endpoint::class.java)
            val callback = endpoint.postNewTodo(post)

            callback.enqueue(object : Callback<PostResponse> {
                override fun onFailure(call: Call<PostResponse>, t: Throwable) {
                    Toast.makeText(context, t.message, Toast.LENGTH_SHORT).show()
                }

                override fun onResponse(call: Call<PostResponse>, response: Response<PostResponse>) {
                    response.body()?.let { IPost.postTodo(it) }
                }
            })
        }
    }
}