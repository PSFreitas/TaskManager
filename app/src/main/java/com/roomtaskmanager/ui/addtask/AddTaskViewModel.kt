package com.roomtaskmanager.ui.addtask

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.roomtaskmanager.data.ResultData
import com.roomtaskmanager.data.TaskEntity
import com.roomtaskmanager.data.TaskRepositoryImp
import kotlinx.coroutines.launch
import java.util.*

class AddTaskViewModel(
    private val taskRepository: TaskRepositoryImp
) : ViewModel() {

    private val _isDataValid: MutableLiveData<Boolean> = MutableLiveData()
    val isDataValid: LiveData<Boolean> = _isDataValid

    private val _createTaskResult: MutableLiveData<Resource<Boolean>> = MutableLiveData()
    val createTaskResult: LiveData<Resource<Boolean>> = _createTaskResult

    val taskTitle = MutableLiveData<String>()
    val taskDescription = MutableLiveData<String>()


    fun verifyTaskTitle(taskTitle: String) {
        _isDataValid.value = taskTitle.isNotEmpty() && taskTitle.isNotBlank()
    }

    fun createTask() {
        val taskEntity = TaskEntity(
            id = 0,
            title = taskTitle.value!!,
            description = taskDescription.value ?: "",
            isFinished = false,
            createdDate = Calendar.getInstance()
        )

        _createTaskResult.value = Resource.loading()

        viewModelScope.launch {
            val result = taskRepository.insertTask(
                taskEntity
            )

            if (result is ResultData.Success) {
                _createTaskResult.value = Resource.success(result.data)
            } else {
                _createTaskResult.value = Resource.error(Exception())
            }
        }
    }


}