package com.example.androidcapstone.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.androidcapstone.database.model.TaskModel


// defining a DATABASE to interact with Dao
@Database(entities = [TaskModel::class], version = 2)
abstract class TaskDatabase: RoomDatabase() {



    // creating an abstract function that inherit from the data access object
    abstract fun taskDao(): TaskDao


}