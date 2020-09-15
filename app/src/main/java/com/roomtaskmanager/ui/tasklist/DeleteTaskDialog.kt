package com.roomtaskmanager.ui.tasklist

import android.app.AlertDialog
import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.ViewModelProvider
import com.roomtaskmanager.R

class DeleteTaskDialog : DialogFragment() {

    private val taskViewModel: ListTaskViewModel? by lazy {
        activity?.run {
            ViewModelProvider(this)[ListTaskViewModel::class.java]
        }
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {

            val builder = AlertDialog.Builder(it)
            builder.setMessage(R.string.cancel_task)
                .setPositiveButton(
                    R.string.confirm,
                    DialogInterface.OnClickListener { dialog, id ->
                        taskViewModel?.deleteTask()
                    })
                .setNegativeButton(R.string.cancel,
                    DialogInterface.OnClickListener { dialog, id ->
                        taskViewModel?.clearTaskToBeDeleted()
                        dismiss()
                    })
            // Create the AlertDialog object and return it
            builder.create()
        } ?: throw IllegalStateException("Activity cannot be null")
    }

}