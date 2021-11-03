package com.example.androidcapstone.database

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.androidcapstone.database.model.TaskModel


//  defining my "Data Access Object" Dao, which is an interface class to interact with the database

@Dao
interface TaskDao {

    @Insert
    suspend fun addTask(taskModel: TaskModel)

    @Query("SELECT * FROM taskmodel")

    // using "LiveData"
    fun getTask(): LiveData<List<TaskModel>>

    @Update
    suspend fun updateTask(taskModel: TaskModel)

    @Delete
    suspend fun deleteTask(taskModel: TaskModel)
}