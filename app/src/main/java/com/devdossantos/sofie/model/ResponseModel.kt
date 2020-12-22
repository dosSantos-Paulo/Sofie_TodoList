package com.devdossantos.sofie.model

import androidx.annotation.Keep

@Keep
data class ResponseModel(
    val data: List<TodoModel>
)