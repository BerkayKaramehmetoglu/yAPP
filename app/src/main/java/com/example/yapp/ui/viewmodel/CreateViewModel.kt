package com.example.yapp.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.example.yapp.data.repository.ToDoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CreateViewModel @Inject constructor(var toDoRepository: ToDoRepository) : ViewModel() {

    fun create(title: String, desc: String, active: Boolean, time: String) {
        CoroutineScope(Dispatchers.Main).launch {
            toDoRepository.createToDo(title, desc, active, time)
        }
    }
}