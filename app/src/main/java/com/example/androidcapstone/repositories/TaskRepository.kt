package com.example.androidcapstone.repositories

import android.content.Context
import androidx.room.Room
import com.example.androidcapstone.database.TaskDatabase
import com.example.androidcapstone.database.model.TaskModel
import java.lang.Exception


private const val DATABASE_NAME = "task-database"
class TaskRepository(context: Context) {

    private val database: TaskDatabase = Room.databaseBuilder(context,TaskDatabase::class.java,
        DATABASE_NAME).fallbackToDestructiveMigration().build()

    private val taskDao = database.taskDao()

    fun getTask()= taskDao.getTask()
    suspend fun addTask(taskModel: TaskModel) = taskDao.addTask(taskModel)
    suspend fun updateTask(taskModel: TaskModel) = taskDao.addTask(taskModel)
    suspend fun deleteTask(taskModel: TaskModel) = taskDao.addTask(taskModel)

    companion object {
        private var instance: TaskRepository? = null

        fun init(context: Context){
            if (instance == null)
                instance = TaskRepository(context)
        }

        fun get(): TaskRepository{
            return instance ?: throw Exception("Task Repository out to be initialized first")
        }
    }


}