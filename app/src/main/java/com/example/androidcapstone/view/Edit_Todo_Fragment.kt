package com.example.androidcapstone.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CheckBox
import android.widget.DatePicker
import android.widget.EditText
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.androidcapstone.R
import com.example.androidcapstone.database.model.TaskModel


class Edit_Todo_Fragment : Fragment() {

    private val taskViewModel: TaskViewModel by activityViewModels()
    private lateinit var selectedTask: TaskModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_edit_todo, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val nameEditText: EditText = view.findViewById(R.id.title_name_edittext111)
        val descriptionEditText: EditText = view.findViewById(R.id.description_edittext222)
        val completionEditText: CheckBox = view.findViewById(R.id.completion1_checkbox111)
        val editButton: Button = view.findViewById(R.id.update_button)
        val datePicker: DatePicker = view.findViewById(R.id.date_picker22)

        taskViewModel.selectedTaskMutableLiveData.observe(viewLifecycleOwner, {
            it?.let {
                nameEditText.setText(it.name)
                descriptionEditText.setText(it.description)



                selectedTask = it
            }
        })
        editButton.setOnClickListener {
            selectedTask.name = nameEditText.text.toString()
            selectedTask.description = descriptionEditText.text.toString()
            selectedTask.completion = completionEditText.isChecked


            val dueDate = "${datePicker.year}/${datePicker.month+1}/${datePicker.dayOfMonth}"


             selectedTask.date = dueDate.toString()


            taskViewModel.updateTask(selectedTask)
            findNavController().navigate(R.id.action_edit_Todo_Fragment_to_taskListFragment)
        }
    }
}

