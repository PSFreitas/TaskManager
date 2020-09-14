package com.roomtaskmanager.ui.converter

import androidx.room.TypeConverters
import java.util.*

class Converters {

    @TypeConverters
    fun fromCalendarToTimestamp(date: Calendar): Long = date.timeInMillis

    @TypeConverters
    fun fromTimestampToCalendar(timestamp: Long): Calendar = Calendar.getInstance().apply {
        timeInMillis = timestamp
    }

}