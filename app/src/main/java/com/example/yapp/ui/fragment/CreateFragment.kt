package com.example.yapp.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.yapp.databinding.FragmentCreateBinding
import com.example.yapp.ui.viewmodel.CreateViewModel
import com.example.yapp.ui.viewmodel.HomeViewModel
import com.example.yapp.util.getCurrentTime
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CreateFragment : Fragment() {
    private lateinit var binding: FragmentCreateBinding
    private lateinit var viewModel: CreateViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCreateBinding.inflate(inflater, container, false)

        binding.createBtn.setOnClickListener {
            val titleEdtTxt = binding.titleEdtTxt.text.toString()
            val descEdtTxt = binding.descEdtTxt.text.toString()
            val active = binding.materialSwitch.isActivated

            viewModel.create(titleEdtTxt, descEdtTxt, active, getCurrentTime())
        }

        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel: CreateViewModel by viewModels()
        viewModel = tempViewModel
    }

}