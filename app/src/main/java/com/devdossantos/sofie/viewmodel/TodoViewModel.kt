package com.devdossantos.sofie.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.liveData
import com.devdossantos.sofie.model.post.Post
import com.devdossantos.sofie.repository.TodoRepository
import kotlinx.coroutines.Dispatchers

class TodoViewModel(
    private val repository: TodoRepository
) : ViewModel() {

    fun getList (email: String) = liveData (Dispatchers.IO) {
        val response = repository.getList(email)
        emit(response.data)
    }

    fun post (post: Post) = liveData (Dispatchers.IO) {
        val response = repository.postNewTodo(post).success
        emit(response)
    }

    class TodoViewModelFactory (
        private val repository: TodoRepository
    ): ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return TodoViewModel(repository) as T
        }

    }
}