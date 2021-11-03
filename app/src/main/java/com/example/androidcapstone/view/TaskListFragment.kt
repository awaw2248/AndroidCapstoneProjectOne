package com.example.androidcapstone.view

import android.os.Bundle
import android.os.RecoverySystem
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.androidcapstone.R
import com.example.androidcapstone.database.model.TaskModel
import com.google.android.material.floatingactionbutton.FloatingActionButton


class TaskListFragment : Fragment() {

    // Declaring the views

    private val taskItems = mutableListOf<TaskModel>()         //**Creating Variables which Represent the List in the Model which
    //==============================================           //which will require creating a data class.
    private val taskViewModel: TaskViewModel by activityViewModels()
    //==============================================

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_task_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // Since we have the Recycler View and the button at list fragment,
        // Adding the recyclerview and the button inside onViewCreated function.

        val taskRecyclerView: RecyclerView = view.findViewById(R.id.task_recyclerview)
        val addFloatingActionButton: FloatingActionButton = view.findViewById(R.id.add_button)
             //====================================
        val taskAdapter = TaskAdapter(taskItems,taskViewModel)
        taskRecyclerView.adapter = taskAdapter
        //=================================================

           taskViewModel.taskItem.observe(viewLifecycleOwner, Observer{
               it?.let {items ->
                   taskItems.clear()
                   taskItems.addAll(items)
                   taskAdapter.notifyDataSetChanged()
               }
           })


         addFloatingActionButton.setOnClickListener{
             findNavController().navigate(R.id.action_taskListFragment_to_addItemFragment)
         }

    }}
