package com.devdossantos.sofie.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.liveData
import com.devdossantos.sofie.repository.TodoRepository
import kotlinx.coroutines.Dispatchers

class TodoViewModel(
    private val repository: TodoRepository
) : ViewModel() {

    fun getList () = liveData (Dispatchers.IO) {
        val response = repository.getList()
        emit(response.data)
    }

    class TodoViewModelFactory (
        private val repository: TodoRepository
    ): ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return TodoViewModel(repository) as T
        }

    }
}