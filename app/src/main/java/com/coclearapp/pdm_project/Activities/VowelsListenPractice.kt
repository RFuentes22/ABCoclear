package com.coclearapp.pdm_project.Activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.coclearapp.pdm_project.R
import kotlinx.android.synthetic.main.activity_vowels_listen_practice.*

class VowelsListenPractice : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_vowels_listen_practice)

        vowels_listen.setOnClickListener {
            startActivity(
                Intent(
                    this,
                    VowelsListen::class.java
                )

            )
        }

    }

}