package com.roomtaskmanager.ui.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "task")
data class TaskEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long,
    @ColumnInfo(name = "task_title")
    val title: String,
    @ColumnInfo(name = "task_description")
    val description: String,
    @ColumnInfo(name = "task_status")
    val isFinished: Boolean,
    @ColumnInfo(name = "task_created_date")
    val createdDate: Calendar
)