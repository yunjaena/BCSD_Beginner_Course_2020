package com.yunjaena.project

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlin.random.Random

class RandomActivity : AppCompatActivity() {
    lateinit var randomInfoTextView: TextView
    lateinit var randomTextView: TextView
    var currentNumber: Int = 0
    var randomNumber: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_random)
        currentNumber = intent.getIntExtra("CURRENT_NUMBER", -1)
        init()
    }

    private fun init() {
        randomTextView = findViewById(R.id.random_text_view)
        randomInfoTextView = findViewById(R.id.radom_info_text_view)
        randomInfoTextView.text = "Here is a ranodom number between 0 and $currentNumber"
        randomTextView.text = getRandomNumber(currentNumber).toString()

    }

    private fun getRandomNumber(maxNumber: Int): Int = Random.nextInt(maxNumber)
}
