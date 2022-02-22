package com.example.workoutapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_active.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    //variable for timer which we be initialize later
    private var countDownTimer: CountDownTimer? = null

    //The duration of the timer in miliseconds
    private var timeDuration: Long = 60000

    //pause Offset = timeDuration - time left
    private var pauseOffset: Long = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//
//        tvTimer.text = "${(timeDuration/1000).toString()}"

        llStart.setOnClickListener {
        val intent = Intent(this, ActiveActivity::class.java)
            startActivity(intent)
        }
    }
}