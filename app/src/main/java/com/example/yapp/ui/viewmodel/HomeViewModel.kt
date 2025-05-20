package com.example.yapp.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.yapp.data.entity.ToDo
import com.example.yapp.data.repository.ToDoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(var toDoRepository: ToDoRepository) : ViewModel() {

    var toDoList = MutableLiveData<List<ToDo>>()

    init {
        load()
    }

    fun search(search: String) {
        CoroutineScope(Dispatchers.Main).launch {
            toDoList.value = toDoRepository.searchToDo(search)
        }
    }

    fun load() {
        CoroutineScope(Dispatchers.Main).launch {
            toDoList.value = toDoRepository.loadToDo()
        }
    }
}