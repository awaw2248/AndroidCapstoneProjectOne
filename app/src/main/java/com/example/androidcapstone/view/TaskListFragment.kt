package com.example.androidcapstone.view

import android.os.Bundle
import android.os.RecoverySystem
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.androidcapstone.R
import com.example.androidcapstone.database.model.TaskModel
import com.google.android.material.floatingactionbutton.FloatingActionButton


class TaskListFragment : Fragment() {

    private val taskItems = mutableListOf<TaskModel>()

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

        val taskRecyclerView: RecyclerView = view.findViewById(R.id.task_recyclerview)
        val addFloatingActionButton: FloatingActionButton = view.findViewById(R.id.add_button)


    }

    companion object {

   }}


