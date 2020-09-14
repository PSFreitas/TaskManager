package com.roomtaskmanager.ui.addtask

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.roomtaskmanager.data.TaskRepositoryImp

class AddTaskViewModelFactory(
    private val taskRepository: TaskRepositoryImp
) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return AddTaskViewModel(taskRepository) as T
    }
}