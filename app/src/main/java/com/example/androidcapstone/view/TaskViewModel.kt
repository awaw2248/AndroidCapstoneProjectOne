package com.example.androidcapstone.view

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.androidcapstone.database.model.TaskModel
import com.example.androidcapstone.repositories.TaskRepository
import kotlinx.coroutines.launch

class TaskViewModel: ViewModel() {

// calling the repository which will be initialized in the main
    private val taskRepository = TaskRepository.get()


    // calling data here
    var taskItem = taskRepository.getTask()

    //===========================
    var selectedTaskMutableLiveData = MutableLiveData<TaskModel>()
    //===========================

// assigning the parameters which we need them to be added
    fun addTask(name: String, completion: Boolean, date:String, description: String){
        viewModelScope.launch{

            // this line will make "add item" work @ the Doa
            taskRepository.addTask(TaskModel(name, completion, date, description))
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