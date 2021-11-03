package com.example.androidcapstone.repositories

import android.content.Context
import androidx.room.Room
import com.example.androidcapstone.database.TaskDatabase
import com.example.androidcapstone.database.model.TaskModel
import java.lang.Exception

// creating a variable and naming the database
private const val DATABASE_NAME = "task-database"

// creating a parameter as a constructor for data build
class TaskRepository(context: Context) {

    private val database: TaskDatabase = Room.databaseBuilder(
        context, TaskDatabase::class.java,
        DATABASE_NAME
    ).fallbackToDestructiveMigration().build()

    private val taskDao = database.taskDao()

    // declaring functions to the database
    fun getTask() = taskDao.getTask()

    suspend fun addTask(taskModel: TaskModel) = taskDao.addTask(taskModel)
    suspend fun updateTask(taskModel: TaskModel) = taskDao.updateTask(taskModel)
    suspend fun deleteTask(taskModel: TaskModel) = taskDao.deleteTask(taskModel)


    // creating single object which contain a constructor.
    companion object {
        private var instance: TaskRepository? = null

        fun init(context: Context) {
            if (instance == null)
                instance = TaskRepository(context)
        }

        fun get(): TaskRepository {
            return instance ?: throw Exception("Task Repository out to be initialized first")
        }
    }


}