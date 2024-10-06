package com.example.myapplication1234.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication1234.R
import com.example.myapplication1234.databinding.ActivityMainBinding
import com.example.myapplication1234.ui.daySchedule.DayScheduleFragment
import com.example.myapplication1234.ui.weekSchedule.WeekScheduleFragment

class MainActivity : AppCompatActivity() {
    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(binding.root)

        supportFragmentManager.beginTransaction()
            .replace(binding.fragmentContainerView.id, WeekScheduleFragment()).commit()

        setUpBottomNavigationClickListener()
    }

    private fun setUpBottomNavigationClickListener() {
        binding.bottomNav.setOnItemSelectedListener { menuItem ->
            val fragment = when (menuItem.itemId) {
                R.id.menu_item_today -> DayScheduleFragment()
                else -> WeekScheduleFragment()
            }

            supportFragmentManager.beginTransaction()
                .replace(binding.fragmentContainerView.id, fragment).commit()
            true
        }
    }

}
