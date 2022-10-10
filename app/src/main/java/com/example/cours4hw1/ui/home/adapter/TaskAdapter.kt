package com.example.cours4hw1.ui.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.cours4hw1.databinding.ItemTaskBinding
import com.example.cours4hw1.ui.Task

class TaskAdapter: RecyclerView.Adapter<TaskAdapter.TaskViewHolder>() {

    private val data= arrayListOf<Task>()

    fun addTask(task: Task){
        data.add(0,task)
        notifyItemChanged(0)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        return TaskViewHolder(ItemTaskBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
       holder.bind(data[position])

    }

    override fun getItemCount(): Int {
        return data.size
    }

    inner class TaskViewHolder(private val binding: ItemTaskBinding):
        RecyclerView.ViewHolder(binding.root) {
        fun bind(task: Task) {
            binding.tvDescription.text=task.descriptor
            binding.tvTitle.text=task.title

        }
    }
}