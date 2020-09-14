package com.roomtaskmanager.ui

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.roomtaskmanager.R
import com.roomtaskmanager.ui.addtask.AddTaskActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onResume() {
        super.onResume()
        setupOnClickListeners()
    }

    private fun setupOnClickListeners() {
        floatingActionButton_add_task.setOnClickListener {
            val intent = Intent(this, AddTaskActivity::class.java)
            startActivityForResult(intent, ADD_TASK_ACTIVITY)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == ADD_TASK_ACTIVITY) {
            if (resultCode == Activity.RESULT_OK) {

            }
        }
    }

    companion object {
        const val ADD_TASK_ACTIVITY = 1
    }
}