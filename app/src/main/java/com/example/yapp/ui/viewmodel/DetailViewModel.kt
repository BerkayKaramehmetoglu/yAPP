package com.example.yapp.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.yapp.data.repository.ToDoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(var toDoRepository: ToDoRepository) : ViewModel() {

    fun update(id: Int, title: String, desc: String, active: Boolean, time: String) {
        CoroutineScope(Dispatchers.Main).launch {
            toDoRepository.updateToDo(id, title, desc, active, time)
        }
    }

    fun delete(id: Int) {
        CoroutineScope(Dispatchers.Main).launch {
            toDoRepository.deleteToDo(id)
        }
    }
}