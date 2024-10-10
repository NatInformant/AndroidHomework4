package com.example.myapplication1234.ui.weekSchedule

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication1234.R
import com.example.myapplication1234.databinding.FragmentRootBinding
import com.example.myapplication1234.ui.adapters.ScheduleAdapter
import com.example.myapplication1234.utils.ScheduleDataUtils.getScheduleForThisDay
import com.example.myapplication1234.utils.ScheduleDataUtils.getScheduleForThisWeek

class RootFragment : Fragment() {

    private var _binding: FragmentRootBinding? = null
    private val binding: FragmentRootBinding
        get() = requireNotNull(_binding)

    private val scheduleAdapter = ScheduleAdapter()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentRootBinding.inflate(
            inflater, container, false
        )
        setUpBottomNavigationClickListener()
        return binding.root
    }

    private fun setUpBottomNavigationClickListener() {
        binding.bottomNav.setOnItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.menu_item_today -> scheduleAdapter.submitValue(getScheduleForThisDay())
                else -> scheduleAdapter.submitValue(getScheduleForThisWeek())
            }
            true
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding.recycler) {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = scheduleAdapter
        }

        scheduleAdapter.submitValue(getScheduleForThisWeek())
    }
}