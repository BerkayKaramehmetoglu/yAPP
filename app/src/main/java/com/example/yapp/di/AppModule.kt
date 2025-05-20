package com.example.yapp.di

import android.content.Context
import androidx.room.Room
import com.example.yapp.data.datasource.ToDoDataSource
import com.example.yapp.data.repository.ToDoRepository
import com.example.yapp.room.Database
import com.example.yapp.room.ToDoDAO
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun provideToDoDataSource(toDoDAO: ToDoDAO): ToDoDataSource {
        return ToDoDataSource(toDoDAO)
    }

    @Provides
    @Singleton
    fun provideToDoRepository(toDoDataSource: ToDoDataSource): ToDoRepository {
        return ToDoRepository(toDoDataSource)
    }

    @Provides
    @Singleton
    fun provideToDoDAO(@ApplicationContext context: Context): ToDoDAO {
        val vt = Room.databaseBuilder(context, Database::class.java, "todo.sqlite")
            .createFromAsset("todo.sqlite").build()
        return vt.getToDoDAO()
    }
}