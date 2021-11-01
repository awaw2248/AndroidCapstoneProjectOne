package com.example.androidcapstone.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.androidcapstone.database.model.TaskModel

@Database(entities = [TaskModel::class], version = 1)
abstract class TaskDatabase: RoomDatabase() {


    abstract fun taskDao(): TaskDao


}