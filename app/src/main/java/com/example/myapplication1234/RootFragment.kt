package com.example.myapplication1234

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication1234.databinding.FragmentRootLayoutBinding

class RootFragment : Fragment() {
    private var _binding: FragmentRootLayoutBinding? = null
    private val binding: FragmentRootLayoutBinding
        get() = requireNotNull(_binding)
    private val textViewAdapter = StudentAdapter(::onStudentCallback)
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentRootLayoutBinding.inflate(
            inflater, container, false
        )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding.recycler) {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = textViewAdapter

        }
        textViewAdapter.submitValue(
            mutableListOf<StudentListItem>(
                StudentListItem.Title("Парни"),
                StudentListItem.StudentLastName("Бойко"),
                StudentListItem.StudentLastName("Устьянцев"),
                StudentListItem.StudentLastName("Кожурков"),
                StudentListItem.StudentLastName("Ломовцев"),
                StudentListItem.StudentLastName("Тиссен"),
                StudentListItem.StudentLastName("Сусоев"),
                StudentListItem.StudentLastName("Бекасов")
            )
        )
    }

    fun onStudentCallback(studentName: String) {
        Toast.makeText(requireContext(), studentName, Toast.LENGTH_LONG).show()
    }
}