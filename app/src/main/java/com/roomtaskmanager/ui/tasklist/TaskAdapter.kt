package com.roomtaskmanager.ui.tasklist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.roomtaskmanager.R
import com.roomtaskmanager.data.TaskEntity
import com.roomtaskmanager.databinding.ItemTaskBinding

class TaskAdapter(
    var tasks: List<TaskEntity> = listOf(),
    var onDeleteTask: OnDeleteTaskListener? = null
) : RecyclerView.Adapter<TaskAdapter.TaskViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        val binding = DataBindingUtil.inflate<ItemTaskBinding>(
            LayoutInflater.from(parent.context),
            R.layout.item_task,
            parent,
            false
        )
        return TaskViewHolder(binding)
    }

    override fun getItemCount(): Int = tasks.size

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) =
        holder.bind(tasks[position], onDeleteTask!!, position)

    class TaskViewHolder(val binding: ItemTaskBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(
            task: TaskEntity,
            onDeleteTask: OnDeleteTaskListener,
            position: Int
        ) {
            binding.task = task
            binding.cardViewTaskItem.setOnLongClickListener {
                onDeleteTask.onDeleteTaskListener(task, position)
                true
            }

        }

    }
}