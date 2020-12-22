package com.devdossantos.sofie.repository

class TodoRepository {
    private val client = TodoListEndpoint.Endpoint
    suspend fun getList() = client.getList()
}