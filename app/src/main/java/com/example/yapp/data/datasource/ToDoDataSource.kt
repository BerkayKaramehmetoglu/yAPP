package com.example.yapp.data.datasource

import com.example.yapp.data.entity.ToDo
import com.example.yapp.room.ToDoDAO
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ToDoDataSource(var toDoDAO: ToDoDAO) {

    suspend fun loadToDo(): List<ToDo> =
        withContext(Dispatchers.IO) {
            return@withContext toDoDAO.loadToDo()
        }

    suspend fun createToDo(title: String, desc: String, active: Boolean, time: String) {
        val newToDo = ToDo(0, title, desc, active, time)
        toDoDAO.createToDo(newToDo)
    }

    suspend fun updateToDo(id: Int, title: String, desc: String, active: Boolean, time: String) {
        val updatedToDo = ToDo(id, title, desc, active, time)
        toDoDAO.updateToDo(updatedToDo)
    }

    suspend fun deleteToDo(id: Int) {
        val deletedToDo = ToDo(id, "", "", false, "")
        toDoDAO.deleteToDo(deletedToDo)
    }

    suspend fun searchToDo(search: String): List<ToDo> =
        withContext(Dispatchers.IO) {
            return@withContext toDoDAO.searchToDo(search)
        }
}