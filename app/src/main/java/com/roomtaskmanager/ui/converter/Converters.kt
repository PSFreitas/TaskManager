package com.roomtaskmanager.ui.converter

import androidx.room.TypeConverter
import java.util.*

class Converters {

    @TypeConverter
    fun fromCalendarToTimestamp(date: Calendar?) = date?.timeInMillis

    @TypeConverter
    fun fromTimestampToCalendar(timestamp: Long?) = timestamp?.let {
        Calendar.getInstance().apply {
            timeInMillis = timestamp
        }
    }

}