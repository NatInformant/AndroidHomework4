package com.example.myapplication1234.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication1234.databinding.ActivityMainBinding
import com.example.myapplication1234.ui.weekSchedule.RootFragment

class MainActivity : AppCompatActivity() {
    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(binding.root)

        supportFragmentManager.beginTransaction()
            .replace(binding.fragmentContainerView.id, RootFragment()).commit()
    }
}
