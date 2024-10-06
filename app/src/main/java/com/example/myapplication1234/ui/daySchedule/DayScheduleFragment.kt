package com.example.myapplication1234.ui.daySchedule

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication1234.databinding.FragmentDayScheduleBinding
import com.example.myapplication1234.ui.adapters.ScheduleAdapter
import com.example.myapplication1234.utils.ScheduleDataUtils.getScheduleForThisDay

class DayScheduleFragment : Fragment() {
    private var _binding: FragmentDayScheduleBinding? = null
    private val binding: FragmentDayScheduleBinding
        get() = requireNotNull(_binding)
    private val textViewAdapter = ScheduleAdapter()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDayScheduleBinding.inflate(
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
            getScheduleForThisDay()
        )
    }
}