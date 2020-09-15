package com.roomtaskmanager.ui.tasklist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.roomtaskmanager.data.TaskRepositoryImp

class ListTaskViewModelFactory(
    val repositoryImp: TaskRepositoryImp
) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return ListTaskViewModel(
            repositoryImp
        ) as T
    }
}