package com.example.androidcapstone.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.androidcapstone.R
import com.example.androidcapstone.database.model.TaskModel


class ItemDetailsFragment : Fragment() {


    private val taskViewModel: TaskViewModel by activityViewModels()
    private lateinit var selectedTask: TaskModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_item_details, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // assigning variables to components id's @ the task details fragment
        val nameTextView: TextView = view.findViewById(R.id.task_name_textview)
        val dateTextView: TextView = view.findViewById(R.id.task_description_textview)
        val completionTextView: TextView = view.findViewById(R.id.task_completion_textview)
        val deleteButton: Button = view.findViewById(R.id.delete_button)
        val editButton: Button = view.findViewById(R.id.update_button)



        taskViewModel.selectedTaskMutableLiveData.observe(viewLifecycleOwner, {
            it?.let {
                nameTextView.text = it.name
                dateTextView.text = "${it.date}"
                completionTextView.text = "Done: ${it.completion}"
                selectedTask = it

            }
        })


           //assigning the delete button @task details screen
        deleteButton.setOnClickListener {
            taskViewModel.deleteTask(selectedTask)
            findNavController().popBackStack()


        }

        //assigning the update,"edit" button @task details fragment
        editButton.setOnClickListener {
            findNavController().navigate(R.id.edit_Todo_Fragment)


        }
        }
    }



