package com.example.androidcapstone.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
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

        val nameEditText: EditText = view.findViewById(R.id.title_name_edittext)
        val descriptionEditText: EditText = view.findViewById(R.id.description_edittext)
        val completionCheckbox: CheckBox = view.findViewById(R.id.completion1_checkbox)
        val saveButton: Button = view.findViewById(R.id.add1_button)

        saveButton.setOnClickListener {
            val name = nameEditText.text.toString()
            val description1 = descriptionEditText.text.toString()
            val completion = completionCheckbox.isChecked

            if (name.isNotEmpty() && description1.isNotEmpty()) {
                taskViewModel.addTask(name, completion, date = String())

                findNavController().popBackStack()
            }
        }
    }
}


