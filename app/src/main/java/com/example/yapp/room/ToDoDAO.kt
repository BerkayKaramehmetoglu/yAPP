package com.example.yapp.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.yapp.data.entity.ToDo

@Dao
interface ToDoDAO {
    @Query("SELECT * FROM todo")
    suspend fun loadToDo(): List<ToDo>

    @Insert
    suspend fun createToDo(toDo: ToDo)

    @Update
    suspend fun updateToDo(toDo: ToDo)

    @Delete
    suspend fun deleteToDo(toDo: ToDo)

    @Query("SELECT * FROM todo WHERE todo_title like '%' || :search || '%'")
    suspend fun searchToDo(search: String): List<ToDo>
}