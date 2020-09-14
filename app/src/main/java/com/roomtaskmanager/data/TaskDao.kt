package com.roomtaskmanager.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface TaskDao {

    @Insert
    suspend fun insertTask(task: TaskEntity)

    @Query("SELECT * FROM task")
    suspend fun getAllTasks(): List<TaskEntity>

    @Delete
    suspend fun deleteTask(task: TaskEntity)

}