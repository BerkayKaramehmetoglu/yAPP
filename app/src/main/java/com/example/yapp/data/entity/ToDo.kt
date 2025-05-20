package com.example.yapp.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable
import org.jetbrains.annotations.NotNull

@Entity(tableName = "todo")
data class ToDo(
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "todo_id") @NotNull var todo_id: Int,
    @ColumnInfo(name = "todo_title") @NotNull var todo_title: String,
    @ColumnInfo(name = "todo_desc") @NotNull var todo_desc: String,
    @ColumnInfo(name = "todo_active") @NotNull var todo_active: Boolean,
    @ColumnInfo(name = "todo_time") @NotNull var todo_time: String
) : Serializable {

}
