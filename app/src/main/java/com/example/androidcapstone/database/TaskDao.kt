package com.example.androidcapstone.database

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.androidcapstone.database.model.TaskModel


@Dao
interface TaskDao {

    @Insert
    suspend fun addTask(taskModel: TaskModel)

    @Query("SELECT * FROM taskmodel")
    fun getTask(): LiveData<List<TaskModel>>

    @Update
    suspend fun updateTask(taskModel: TaskModel)

    @Delete
    suspend fun deleteTask(taskModel: TaskModel)
}