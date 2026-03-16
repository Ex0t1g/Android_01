package com.example.android

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.util.Timer

class MainActivity : AppCompatActivity() {
    private var onCreateTime: Long = 0
    private var onStartTime: Long = 0
    private var onResumeTime: Long = 0
    private var onPauseTime: Long = 0
    private var onStopTime: Long = 0
    private var onDestroyTime: Long = 0
    override fun onCreate(savedInstanceState: Bundle?) {


        val startTime = System.currentTimeMillis()
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val endTime = System.currentTimeMillis()
        val executeTime = endTime - startTime

        Log.d("[MainActivity]: ", "OnCreate was initialized... | in $executeTime ms");
    }


    override fun onStart() {
        super.onStart()
        onStartTime = System.currentTimeMillis()

        val diffOnCreateOnStart = onStartTime - onCreateTime
        Log.d("[MainActivity]: ", "onStart was initialized...")
        Log.d("[MainActivity]: ", "Time between onCreate and onStart: $diffOnCreateOnStart ms")
    }

    override fun onResume() {
        super.onResume()
        onResumeTime = System.currentTimeMillis()

        val diffOnCreateOnResume = onResumeTime - onCreateTime
        val diffOnStartOnResume = onResumeTime - onStartTime

        Log.d("[MainActivity]: ", "onResume was initialized...")
        Log.d("[MainActivity]: ", "Time between onCreate and onResume: $diffOnCreateOnResume ms")
        Log.d("[MainActivity]: ", "Time between onStart and onResume: $diffOnStartOnResume ms")
    }

    override fun onPause() {
        super.onPause()
        onPauseTime = System.currentTimeMillis()

        val diffOnResumeOnPause = onPauseTime - onResumeTime

        Log.d("[MainActivity]: ", "onPause was initialized...")
        Log.d("[MainActivity]: ", "Time between onResume and onPause: $diffOnResumeOnPause ms")
    }

    override fun onStop() {
        super.onStop()
        onStopTime = System.currentTimeMillis()

        val diffOnPauseOnStop = onStopTime - onPauseTime

        Log.d("[MainActivity]: ", "onStop was initialized...")
        Log.d("[MainActivity]: ", "Time between onPause and onStop: $diffOnPauseOnStop ms")
    }

    override fun onDestroy() {
        super.onDestroy()
        onDestroyTime = System.currentTimeMillis()

        val diffOnStopOnDestroy = onDestroyTime - onStopTime

        Log.d("[MainActivity]: ", "onDestroy was initialized...")
        Log.d("[MainActivity]: ", "Time between onStop and onDestroy: $diffOnStopOnDestroy ms")
    }

}
