package com.coclearapp.pdm_project.Activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.coclearapp.pdm_project.R
import kotlinx.android.synthetic.main.activity_instruments_listen_practice.*
import kotlinx.android.synthetic.main.activity_vowels_listen_practice.*

class InstrumentsListenPractice : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_instruments_listen_practice)

        instruments_listen.setOnClickListener {
            startActivity(
                Intent(
                    this,
                    InstrumentsListen::class.java
                )

            )
        }
    }
}