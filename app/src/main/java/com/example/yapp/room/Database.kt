package com.example.yapp.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.yapp.data.entity.ToDo

@Database(entities = [ToDo::class], version = 1)
abstract class Database : RoomDatabase() {
    abstract fun getToDoDAO() : ToDoDAO
}