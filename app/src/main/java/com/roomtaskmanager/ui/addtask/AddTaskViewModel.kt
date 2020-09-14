package com.roomtaskmanager.ui.addtask

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.roomtaskmanager.data.TaskRepositoryImp

class AddTaskViewModel(
    private val taskRepository: TaskRepositoryImp
) : ViewModel() {

    private val _isDataValid: MutableLiveData<Boolean> = MutableLiveData()
    val isDataValid: LiveData<Boolean> = _isDataValid


    fun verifyTaskTitle(taskTitle: String) {
        _isDataValid.value = taskTitle.isNotEmpty() && taskTitle.isNotBlank()
    }


}