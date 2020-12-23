package com.devdossantos.sofie.oldversionrequest.get

import android.content.Context
import android.widget.Toast
import com.devdossantos.sofie.model.get.ResponseModel
import com.devdossantos.sofie.oldversionrequest.endpoint.Endpoint
import com.devdossantos.sofie.utils.NetworkUtils
import com.devdossantos.sofie.view.main.MainFragment.Companion.EMAIL
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CallBackApi {
    companion object {
        fun getData(context: Context, iRespostaDaApi: IRespostaDaApi) {
            val retrofitClient = NetworkUtils.getRetrofit()

            val endpoint = retrofitClient.create(Endpoint::class.java)
            val callback = endpoint.getTodoList(EMAIL)

            callback.enqueue(object : Callback<ResponseModel> {
                override fun onFailure(call: Call<ResponseModel>, t: Throwable) {
                    Toast.makeText(context, t.message, Toast.LENGTH_SHORT).show()
                }

                override fun onResponse(call: Call<ResponseModel>, response: Response<ResponseModel>) {
                    response.body()?.let { iRespostaDaApi.getTodo(it.data) }
                }
            })
        }
    }
}