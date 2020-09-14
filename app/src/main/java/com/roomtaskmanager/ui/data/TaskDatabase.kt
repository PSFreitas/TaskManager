package com.roomtaskmanager.ui.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.roomtaskmanager.ui.converter.Converters

@Database(
    entities = [TaskEntity::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(Converters::class)
abstract class TaskDatabase : RoomDatabase() {

    abstract val taskDao: TaskDao

    companion object {

        private const val DATABASE_NAME = "task-db"

        @Volatile
        private var INSTANCE: TaskDatabase? = null

        fun getInstance(applicationContext: Context): TaskDatabase {
            if (INSTANCE == null) {
                synchronized(TaskDatabase::class) {
                    INSTANCE = Room.databaseBuilder(
                        applicationContext,
                        TaskDatabase::class.java,
                        DATABASE_NAME
                    ).build()
                }
            }
            return INSTANCE as TaskDatabase
        }

    }

}