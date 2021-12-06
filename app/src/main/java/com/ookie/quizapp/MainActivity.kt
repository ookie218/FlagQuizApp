package com.ookie.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn_start : Button = findViewById(R.id.btnStart)
        val et_name : EditText = findViewById(R.id.et_name)

        btn_start.setOnClickListener {
            //Lambda Function
            if (et_name.text.isEmpty()) { //If empty, display Toast
                Toast.makeText(this, "Please Enter Your Name!", Toast.LENGTH_LONG).show()
            } else { //Start New Activity
                val intent = Intent(this, QuizQuestions::class.java)
                intent.putExtra(Constants.USER_NAME, et_name.text.toString())
                startActivity(intent)
                finish()
            }

        }

    }
}