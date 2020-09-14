package com.roomtaskmanager.ui.tasklist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.roomtaskmanager.data.ResultData
import com.roomtaskmanager.data.TaskEntity
import com.roomtaskmanager.data.TaskRepositoryImp
import com.roomtaskmanager.ui.addtask.Resource
import kotlinx.coroutines.launch

class ListTaskViewModel(
    val taskRepositoryImp: TaskRepositoryImp
) : ViewModel() {

    private val _getAllTasksResult: MutableLiveData<Resource<List<TaskEntity>>> = MutableLiveData()
    val getAllTaskResult: LiveData<Resource<List<TaskEntity>>> = _getAllTasksResult

    fun getAllTasks() {
        _getAllTasksResult.value = Resource.loading()

        viewModelScope.launch {
            val result = taskRepositoryImp.getAllTasks()

            if (result is ResultData.Success) {
                _getAllTasksResult.value = Resource.success(result.data)
            } else {
                _getAllTasksResult.value = Resource.error(Exception())
            }

        }
    }
}