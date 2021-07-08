package com.coclearapp.pdm_project.Activities

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.coclearapp.pdm_project.R
import kotlinx.android.synthetic.main.activity_instruments_listen_practice.*

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

        instruments_practice.setOnClickListener {
            startActivity(
                Intent(
                    this,
                    InstumentsPractice::class.java
                )

            )
        }
    }
}