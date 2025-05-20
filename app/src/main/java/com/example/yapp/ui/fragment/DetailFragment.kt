package com.example.yapp.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import com.example.yapp.R
import com.example.yapp.databinding.FragmentDetailBinding
import com.example.yapp.ui.viewmodel.DetailViewModel
import com.example.yapp.util.getCurrentTime
import com.google.android.material.snackbar.Snackbar
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
        binding.materialSwitch.isChecked = bundle.todo.todo_active

        binding.updateBtn.setOnClickListener {
            val title = binding.titleEdtTxt.text.toString()
            val desc = binding.descEdtTxt.text.toString()
            val active = binding.materialSwitch.isChecked

            viewModel.update(comingToDo.todo_id, title, desc, active, getCurrentTime())
            Snackbar.make(it, "Updated", Snackbar.LENGTH_SHORT).show()
            it.findNavController().navigate(R.id.detail_to_home)
        }

        binding.delete.setOnClickListener { view ->
            Snackbar.make(view, "${bundle.todo.todo_title} deleted", Snackbar.LENGTH_SHORT)
                .setAction("YES") {
                    val toDoId = comingToDo.todo_id
                    viewModel.delete(toDoId)
                    view.findNavController().navigate(R.id.detail_to_home)
                }
                .show()
        }

        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel: DetailViewModel by viewModels()
        viewModel = tempViewModel
    }
}