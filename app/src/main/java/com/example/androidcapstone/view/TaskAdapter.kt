package com.example.androidcapstone.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.androidcapstone.R
import com.example.androidcapstone.database.model.TaskModel

class TaskAdapter(val tasks: List<TaskModel>, val vewModel: TaskViewModel) : RecyclerView.Adapter<TaskAdapter.TaskViewHolder>() {




    class TaskViewHolder(view: View): RecyclerView.ViewHolder(view){
        val nameTextView: TextView = view.findViewById(R.id.textView11)
        val due: TextView = view.findViewById(R.id.textView22)
        val completion: CheckBox = view.findViewById(R.id.completion1_checkbox)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        return TaskViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent,false))
    }

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        val task = tasks[position]

         holder.nameTextView.text= task.name
        holder.due.text= task.date
        holder.completion.isChecked=task.completion
    }

    override fun getItemCount(): Int {
return tasks.size   }
}