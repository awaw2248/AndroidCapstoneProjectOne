package com.example.androidcapstone.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.androidcapstone.R


class AddItemFragment : Fragment() {

    private val taskViewModel: TaskViewModel by activityViewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add_item, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // assigning variables to components id's @ the task add fragment

        val nameEditText: EditText = view.findViewById(R.id.title_name_edittext111)
        val descriptionEditText: EditText = view.findViewById(R.id.description_edittext222)
        val completionCheckbox: CheckBox = view.findViewById(R.id.completion1_checkbox111)
        val saveButton: Button = view.findViewById(R.id.save_button)
        val datePicker: DatePicker = view.findViewById(R.id.date_picker11)

        saveButton.setOnClickListener {
            val name = nameEditText.text.toString()
            val description1 = descriptionEditText.text.toString()
            val completion = completionCheckbox.isChecked
            val dueDate = "${datePicker.year}/${datePicker.month+1}/${datePicker.dayOfMonth}"


            if (name.isNotEmpty() && description1.isNotEmpty()) {
                taskViewModel.addTask(name, completion, dueDate, description1)

                findNavController().popBackStack()
            }
        }
    }
}


