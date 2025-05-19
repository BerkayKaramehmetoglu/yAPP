package com.example.yapp.data.entity

data class ToDo(
    var todo_id: Int,
    var todo_title: String,
    var todo_desc: String,
    var todo_active: Boolean,
    var todo_time: String
)
