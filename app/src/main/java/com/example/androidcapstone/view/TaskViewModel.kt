package com.example.androidcapstone.view

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.androidcapstone.database.model.TaskModel
import com.example.androidcapstone.repositories.TaskRepository

class TaskViewModel: ViewModel() {


    private val taskRepository = TaskRepository.get()

    var taskItem = taskRepository.getTask()

    //===========================
    var selectedTaskMutableLiveData = MutableLiveData<TaskModel>()
    //===========================


    fun addTask(name: String, completion: Boolean, date:String){
        viewModelScope.launch{
            taskRepository.addTask(TaskModel(name, completion, date))
        }
    }

    fun deleteTask(taskModel: TaskModel){
        viewModelScope.launch{
            taskRepository.deleteTask(taskModel)
        }
    }

    fun updateTask(taskModel: TaskModel){
        viewModelScope.launch{
            taskRepository.updateTask(taskModel)
        }
    }


}