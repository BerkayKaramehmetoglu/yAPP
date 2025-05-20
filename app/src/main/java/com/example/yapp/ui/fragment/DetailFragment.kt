package com.example.yapp.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.example.yapp.databinding.FragmentDetailBinding
import com.example.yapp.ui.viewmodel.DetailViewModel
import com.example.yapp.util.getCurrentTime
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailFragment : Fragment() {
    private lateinit var binding: FragmentDetailBinding
    private lateinit var viewModel: DetailViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailBinding.inflate(inflater, container, false)

        val bundle: DetailFragmentArgs by navArgs()
        val comingToDo = bundle.todo

        binding.titleEdtTxt.setText(comingToDo.todo_title)
        binding.descEdtTxt.setText(comingToDo.todo_desc)
        binding.materialSwitch.isActivated = bundle.todo.todo_active

        binding.updateBtn.setOnClickListener {
            val title = binding.titleEdtTxt.text.toString()
            val desc = binding.descEdtTxt.text.toString()
            val active = binding.materialSwitch.isActivated

            viewModel.update(comingToDo.todo_id, title, desc, active, getCurrentTime())
        }

        binding.delete.setOnClickListener {
            val toDoId = comingToDo.todo_id
            viewModel.delete(toDoId)
        }

        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel: DetailViewModel by viewModels()
        viewModel = tempViewModel
    }
}