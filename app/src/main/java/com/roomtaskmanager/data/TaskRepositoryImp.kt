package com.roomtaskmanager.data

class TaskRepositoryImp(
    private val database: TaskDatabase
) : TaskRepository {
    override suspend fun insertTask(task: TaskEntity): ResultData<Boolean> {
        database.taskDao.insertTask(task)
        return ResultData.Success(data = true)
    }

    override suspend fun getAllTasks(): ResultData<List<TaskEntity>> {
        return ResultData.Success(data = database.taskDao.getAllTasks())
    }

    override suspend fun deleteTask(task: TaskEntity): ResultData<Boolean> {
        database.taskDao.deleteTask(task)
        return ResultData.Success(data = true)
    }

}