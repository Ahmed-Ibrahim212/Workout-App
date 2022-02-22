package com.example.workoutapp

import android.media.MediaPlayer
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.speech.tts.TextToSpeech
import android.util.Log
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_active.*
import java.util.*
import kotlin.collections.ArrayList

class ActiveActivity : AppCompatActivity(), TextToSpeech.OnInitListener {
    private var restTimer: CountDownTimer? = null
    private var restProgress = 0


    private var exerciseTimer: CountDownTimer? = null
    private var exerciseProgress = 0
    private var exerciseTimerDuration: Long = 5

    private var exerciseList: ArrayList<ExerciseModel>? = null
    private var exerciseCurrentPosition = -1

    //text to speech initializing
    private var tts: TextToSpeech? = null

//    // adding media player
//    private var player: MediaPlayer? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_active)

        setSupportActionBar(toolBarActivity)
        val actionbar = supportActionBar
        actionbar?.setDisplayHomeAsUpEnabled(true)

        toolBarActivity.setNavigationOnClickListener {
            onBackPressed()
        }

        //passing the initialization as a part of this activity
        tts = TextToSpeech(this, this)

        exerciseList = Constant.defaultExerciseList()
        setupRestView()
    }

    override fun onDestroy() {
        if (restTimer != null) {
            restTimer!!.cancel()
            restProgress = 0
        }
        if (exerciseTimer != null) {
            exerciseTimer!!.cancel()
            exerciseProgress = 0
        }

        if (tts != null) {
            tts!!.stop()
            tts!!.shutdown()
        }
//        if (player!=null){
//            player!!.stop()
//        }


        super.onDestroy()

    }


    private fun setRestProgressBar() {
        progressBar.progress = restProgress
        restTimer = object : CountDownTimer(10000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                restProgress++
                progressBar.progress = 10 - restProgress
                tvTimer.text = (10 - restProgress).toString()
            }

            override fun onFinish() {
                exerciseCurrentPosition++
                setupExerciseView()
            }
        }.start()
    }

    private fun setExerciseProgressBar() {
        progressBarExercise.progress = exerciseProgress
        exerciseTimer = object : CountDownTimer(exerciseTimerDuration * 1000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                exerciseProgress++
                progressBarExercise.progress = exerciseTimerDuration.toInt() - exerciseProgress
                tvTimer2.text = (exerciseTimerDuration - exerciseProgress).toString()
            }

            override fun onFinish() {
                if (exerciseCurrentPosition < exerciseList?.size!! - 1) {
                    setupRestView()
                } else {
                    Toast.makeText(
                        this@ActiveActivity,
                        "Congratulations!, You have completed the 7 minutes work out.",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }.start()

    }

    private fun setupRestView() {
//        try {
//            player = MediaPlayer.create(applicationContext, R.raw.sound)
//            player!!.isLooping = false
//            player!!.start()
//        }catch (e:Exception){
//            e.printStackTrace()
//        }


        restView.visibility = View.VISIBLE
        exerciseView.visibility = View.GONE

        if (restTimer != null) {
            restTimer!!.cancel()
            restProgress = 0
        }


        tvExerciseUpcomingName.text = exerciseList!![exerciseCurrentPosition + 1].getName()

        setRestProgressBar()

    }

    private fun setupExerciseView() {

        restView.visibility = View.GONE
        exerciseView.visibility = View.VISIBLE

        if (exerciseTimer != null) {
            exerciseTimer!!.cancel()
            exerciseProgress = 0
        }

        speakOut(exerciseList!![exerciseCurrentPosition].getName())

        setExerciseProgressBar()

        ivImage.setImageResource(exerciseList!![exerciseCurrentPosition].getImage())
        tvExercise.text = exerciseList!![exerciseCurrentPosition].getName()
    }

    override fun onInit(status: Int) {
        if (status == TextToSpeech.SUCCESS) {
            val result = tts!!.setLanguage(Locale.US)
            if (result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_MISSING_DATA) {
                Log.e("TTS", "The language specified is not supported! ")
            } else {
                Log.e("TTS", "initialization failed!")
            }
        }
    }

    private fun speakOut(text: String) {
        tts!!.speak(text, TextToSpeech.QUEUE_FLUSH, null, "")
    }
}