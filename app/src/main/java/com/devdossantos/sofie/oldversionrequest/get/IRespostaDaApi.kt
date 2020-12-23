package com.devdossantos.sofie.oldversionrequest.get

import com.devdossantos.sofie.model.get.TodoModel

interface IRespostaDaApi {
    fun getTodo (tarefas: List<TodoModel>)
}
