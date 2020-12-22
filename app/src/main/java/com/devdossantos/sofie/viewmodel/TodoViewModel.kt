package com.devdossantos.sofie.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.liveData
import com.devdossantos.sofie.model.TodoModel
import com.devdossantos.sofie.repository.TodoRepository
import kotlinx.coroutines.Dispatchers

class TodoViewModel(
    private val repository: TodoRepository
) : ViewModel() {
    private var todoList : MutableList<TodoModel> = mutableListOf()

    fun getList () = liveData(Dispatchers.IO) {
        val response = repository.getList()
        todoList.addAll(response)
        emit(todoList)
    }

    class TodoViewModelFactory (
        private val repository: TodoRepository
    ): ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return TodoViewModelFactory(repository) as T
        }

    }
}