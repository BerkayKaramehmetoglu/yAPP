package com.example.yapp.util

import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

fun getCurrentTime(): String {
    val date = Date()
    val formatter = SimpleDateFormat("HH:mm dd.MM.yyyy", Locale.getDefault())
    return formatter.format(date)
}