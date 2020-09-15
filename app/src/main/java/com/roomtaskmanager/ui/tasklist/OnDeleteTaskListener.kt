package com.roomtaskmanager.ui.tasklist

import com.roomtaskmanager.data.TaskEntity

interface OnDeleteTaskListener {
    fun onDeleteTaskListener(taskEntity: TaskEntity, index: Int)
}
