package com.roomtaskmanager

import android.widget.TextView
import androidx.databinding.BindingAdapter
import java.text.SimpleDateFormat
import java.util.*


class BindingAdapters {

    companion object {
        @JvmStatic
        @BindingAdapter("formatCalendar")
        fun formatCNPJ(textView: TextView, calendar: Calendar?) {
            if (calendar != null) {
                val dateFormat = SimpleDateFormat("dd/MM/yyyy")
                textView.text = dateFormat.format(calendar.time)
            }
        }
    }

}