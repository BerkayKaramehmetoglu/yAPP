package com.example.yapp.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.yapp.R
import com.example.yapp.data.entity.ToDo
import com.example.yapp.databinding.CardDesignBinding
import androidx.navigation.findNavController

class YappAdapter(var context: Context, var toDoList: List<ToDo>) :
    RecyclerView.Adapter<YappAdapter.CardViewHolder>() {

    inner class CardViewHolder(var design: CardDesignBinding) :
        RecyclerView.ViewHolder(design.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder {
        val binding = CardDesignBinding.inflate(LayoutInflater.from(context), parent, false)
        return CardViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return toDoList.size
    }

    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {
        val toDoLists = toDoList[position]
        val design = holder.design

        design.todoId.text = "yAPP ${toDoLists.todo_id}"
        design.todoTitle.text = toDoLists.todo_title

        if (toDoLists.todo_active) {
            design.active.setImageResource(R.drawable.baseline_circle_green_24)
        } else {
            design.active.setImageResource(R.drawable.baseline_circle_red_24)
        }

        design.todoTime.text = toDoLists.todo_time

        design.cardView.setOnClickListener {
            it.findNavController().navigate(R.id.home_to_detail)
        }
    }
}