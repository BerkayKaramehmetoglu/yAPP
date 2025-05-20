package com.example.yapp.data.repository

import com.example.yapp.data.datasource.ToDoDataSource
import com.example.yapp.data.entity.ToDo

class ToDoRepository(var toDoDataSource: ToDoDataSource) {

    suspend fun loadToDo(): List<ToDo> = toDoDataSource.loadToDo()

    suspend fun createToDo(title: String, desc: String, active: Boolean, time: String) =
        toDoDataSource.createToDo(title, desc, active, time)

    suspend fun updateToDo(id: Int, title: String, desc: String, active: Boolean, time: String) =
        toDoDataSource.updateToDo(id, title, desc, active, time)

    suspend fun deleteToDo(id: Int) = toDoDataSource.deleteToDo(id)

    suspend fun searchToDo(search: String): List<ToDo> = toDoDataSource.searchToDo(search)
}