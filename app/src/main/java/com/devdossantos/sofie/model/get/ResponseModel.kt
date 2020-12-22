package com.devdossantos.sofie.model.get

import androidx.annotation.Keep

@Keep
data class ResponseModel(
    val data: List<TodoModel>
)