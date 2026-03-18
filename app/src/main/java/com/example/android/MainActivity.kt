package com.example.android

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.android.databinding.ActivityMainBinding
import java.util.Timer

class MainActivity : AppCompatActivity() {
    private var onCreateTime: Long = 0
    private var onStartTime: Long = 0
    private var onResumeTime: Long = 0
    private var onPauseTime: Long = 0
    private var onStopTime: Long = 0
    private var onDestroyTime: Long = 0

    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {


        val startTime = System.currentTimeMillis()
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val endTime = System.currentTimeMillis()
        val executeTime = endTime - startTime

    }


}
