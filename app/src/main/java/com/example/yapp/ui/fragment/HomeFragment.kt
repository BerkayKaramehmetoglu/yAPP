package com.example.yapp.ui.fragment

import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.yapp.data.entity.ToDo
import com.example.yapp.databinding.FragmentHomeBinding
import com.example.yapp.ui.adapter.YappAdapter
import java.text.SimpleDateFormat
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.Date
import java.util.Locale

class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)

        binding.homeRv.layoutManager = LinearLayoutManager(requireContext())

        val toDoList = listOf(
            ToDo(
                1, "Deneme", "DenemeDenemeDeneme", true, getCurrentTime()
            ),
            ToDo(
                2, "Deneme2", "Deneme2Deneme2Deneme2", false, getCurrentTime()
            ),
            ToDo(
                3, "Deneme3", "Deneme3Deneme3Deneme3", false, getCurrentTime()
            ),
            ToDo(
                4, "Deneme4", "Deneme4Deneme4Deneme4", false, getCurrentTime()
            ),
        )

        val yAPPAdapter = YappAdapter(requireContext(), toDoList)
        binding.homeRv.adapter = yAPPAdapter

        binding.search.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                return true
            }

        })


        return binding.root
    }

    fun getCurrentTime(): String {
        val date = Date()
        val formatter = SimpleDateFormat("HH:mm dd.MM.yyyy", Locale.getDefault())
        return formatter.format(date)
    }
}