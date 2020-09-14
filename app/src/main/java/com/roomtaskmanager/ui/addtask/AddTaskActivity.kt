package com.roomtaskmanager.ui.addtask

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.roomtaskmanager.R
import com.roomtaskmanager.data.TaskDatabase
import com.roomtaskmanager.data.TaskEntity
import com.roomtaskmanager.data.TaskRepositoryImp
import com.roomtaskmanager.databinding.ActivityAddTaskBinding
import kotlinx.android.synthetic.main.activity_add_task.*
import java.util.*

class AddTaskActivity : AppCompatActivity() {


    private val addTaskViewModel by lazy {
        val taskRepositoryImp = TaskRepositoryImp(
            TaskDatabase.getInstance(this)
        )
        ViewModelProvider(
            this,
            AddTaskViewModelFactory(
                taskRepositoryImp
            )
        ).get(AddTaskViewModel::class.java)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        DataBindingUtil.setContentView<ActivityAddTaskBinding>(
            this,
            R.layout.activity_add_task
        )
            .let {
                it.viewModel = addTaskViewModel
                it.lifecycleOwner = this
            }
    }

    override fun onResume() {
        super.onResume()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> onBackPressed()
        }
        return super.onOptionsItemSelected(item)
    }

}