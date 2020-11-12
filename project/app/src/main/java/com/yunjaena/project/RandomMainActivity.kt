package com.yunjaena.project

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class RandomMainActivity : AppCompatActivity(), View.OnClickListener {
    var countNumber = 0
    lateinit var countTextView: TextView
    lateinit var toastButton: Button
    lateinit var countButton: Button
    lateinit var randomButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_random_main)
        init()
    }

    private fun init() {
        countTextView = findViewById(R.id.count_text_view)
        toastButton = findViewById(R.id.toast_button)
        countButton = findViewById(R.id.count_button)
        randomButton = findViewById(R.id.radom_button)
        toastButton.setOnClickListener(this)
        countButton.setOnClickListener(this)
        randomButton.setOnClickListener(this)
        countTextView.text = countNumber.toString()
    }

    override fun onClick(view: View?) {
        when (view!!.id) {
            R.id.toast_button -> showToastMessage()
            R.id.count_button -> countNumber()
            R.id.radom_button -> goToRandomActivity()
        }
    }

    private fun showToastMessage() {
        Toast.makeText(applicationContext, "Current is ${countNumber}.", Toast.LENGTH_SHORT).show()
    }

    private fun countNumber() {
        countNumber++
        countTextView.text = countNumber.toString()
    }

    private fun goToRandomActivity() {
        var intent = Intent(this@RandomMainActivity, RandomActivity::class.java)
        intent.putExtra("CURRENT_NUMBER", countNumber)
        startActivity(intent)
    }
}
