package com.roomtaskmanager.ui.addtask

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.doAfterTextChanged
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.roomtaskmanager.R
import com.roomtaskmanager.data.TaskDatabase
import com.roomtaskmanager.data.TaskRepositoryImp
import com.roomtaskmanager.databinding.ActivityAddTaskBinding
import kotlinx.android.synthetic.main.activity_add_task.*


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
        ).let {
            it.viewModel = addTaskViewModel
            it.lifecycleOwner = this
        }
    }

    override fun onResume() {
        super.onResume()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        setupOnTextChangedListeners()
        setupObservers()


    }

    private fun setupObservers() {
        addTaskViewModel.createTaskResult.observe(
            this,
            Observer { resource ->
                if (resource.status == Status.SUCCESS) {
                    val returnIntent = Intent()
                    setResult(Activity.RESULT_OK, returnIntent)
                    finish()
                }
            }
        )
    }


    private fun setupOnTextChangedListeners() {
        textInputEditText_task_name.doAfterTextChanged {
            addTaskViewModel.verifyTaskTitle(it.toString())
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                val returnIntent = Intent()
                setResult(Activity.RESULT_CANCELED, returnIntent)
                onBackPressed()
            }
        }
        return super.onOptionsItemSelected(item)
    }

}