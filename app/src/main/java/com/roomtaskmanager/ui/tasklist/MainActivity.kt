package com.roomtaskmanager.ui.tasklist

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.roomtaskmanager.R
import com.roomtaskmanager.data.TaskDatabase
import com.roomtaskmanager.data.TaskRepositoryImp
import com.roomtaskmanager.databinding.ActivityMainBinding
import com.roomtaskmanager.ui.addtask.AddTaskActivity
import com.roomtaskmanager.ui.addtask.Status
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val taskListViewModel by lazy {
        val taskRepositoryImp = TaskRepositoryImp(
            TaskDatabase.getInstance(this)
        )
        ViewModelProvider(
            this,
            ListTaskViewModelFactory(
                taskRepositoryImp
            )
        ).get(ListTaskViewModel::class.java)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        DataBindingUtil.setContentView<ActivityMainBinding>(
            this,
            R.layout.activity_main
        ).let {
            it.lifecycleOwner = this
            it.viewModel = taskListViewModel
        }
        getAllTasks()
    }

    private fun getAllTasks() {
        taskListViewModel.getAllTasks()
    }

    override fun onResume() {
        super.onResume()
        setupOnClickListeners()
        setupObservables()
    }

    private fun setupObservables() {
        taskListViewModel.getAllTaskResult.observe(
            this,
            Observer {
                if (it.status == Status.SUCCESS) {
                }
            }
        )
    }

    private fun setupOnClickListeners() {
        floatingActionButton_add_task.setOnClickListener {
            val intent = Intent(this, AddTaskActivity::class.java)
            startActivityForResult(
                intent,
                ADD_TASK_ACTIVITY
            )
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == ADD_TASK_ACTIVITY) {
            if (resultCode == Activity.RESULT_OK) {
                taskListViewModel.getAllTasks()
            }
        }
    }

    companion object {
        const val ADD_TASK_ACTIVITY = 1
    }
}