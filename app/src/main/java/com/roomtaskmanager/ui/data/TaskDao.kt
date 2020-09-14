package com.roomtaskmanager.ui.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface TaskDao {

    @Insert
    fun insertTask(task: TaskEntity)

    @Query("SELECT * FROM task")
    fun getAllTasks(): List<TaskEntity>

    @Delete
    fun deleteTask(task: TaskEntity)

}