package com.roomtaskmanager.data

interface TaskRepository {

    suspend fun insertTask(task: TaskEntity) : ResultData<Boolean>

    suspend fun getAllTasks(): ResultData<List<TaskEntity>>

    suspend fun deleteTask(task: TaskEntity) : ResultData<Boolean>

}