package com.example.myapplication1234.ui.weekSchedule

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication1234.databinding.FragmentWeekScheduleBinding
import com.example.myapplication1234.ui.adapters.ScheduleAdapter
import com.example.myapplication1234.utils.ScheduleDataUtils.weekScheduleList

class WeekScheduleFragment : Fragment() {

    private var _binding: FragmentWeekScheduleBinding? = null
    private val binding: FragmentWeekScheduleBinding
        get() = requireNotNull(_binding)

    private val scheduleAdapter = ScheduleAdapter()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentWeekScheduleBinding.inflate(
            inflater, container, false
        )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding.recycler) {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = scheduleAdapter
        }

        scheduleAdapter.submitValue(weekScheduleList)
    }
}