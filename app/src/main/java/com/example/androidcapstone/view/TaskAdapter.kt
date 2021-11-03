package com.example.androidcapstone.view

import android.graphics.Color
import android.icu.text.DateFormat
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.androidcapstone.R
import com.example.androidcapstone.database.model.TaskModel
import java.text.SimpleDateFormat
import java.util.*

class TaskAdapter(val tasks: List<TaskModel>, val viewModel: TaskViewModel) : RecyclerView.Adapter<TaskAdapter.TaskViewHolder>() {




    class TaskViewHolder(view: View): RecyclerView.ViewHolder(view){
        val nameTextView: TextView = view.findViewById(R.id.textView11)
        val due: TextView = view.findViewById(R.id.textView22)
        val completion: CheckBox = view.findViewById(R.id.completion1_checkbox)
        val creationDate: TextView = view.findViewById(R.id.creation_date)
    }
      
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        return TaskViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent,false))
    }

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        val task = tasks[position]

         holder.nameTextView.text= task.name
        holder.due.text= task.date
        holder.creationDate.text= task.crationdate
        holder.completion.isChecked=task.completion


        val formatDate = SimpleDateFormat("yyyy/MM/dd")
        val dueDate = formatDate.parse(task.date)

        if (Date() > dueDate){
            holder.nameTextView.setTextColor(Color.parseColor("#b00020"))
        }

        holder.itemView.setOnClickListener{ it ->
            viewModel.selectedTaskMutableLiveData.postValue(task)
            it.findNavController().navigate(R.id.action_taskListFragment_to_itemDetailsFragment)
            
            holder.itemView.setOnClickListener{
                viewModel.selectedTaskMutableLiveData.postValue(task)
                it.findNavController().navigate(R.id.action_itemDetailsFragment_to_edit_Todo_Fragment)
            }


        }
    }

    override fun getItemCount(): Int {
return tasks.size   }
}