package com.coclearapp.pdm_project.Activities

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.coclearapp.pdm_project.R
import kotlinx.android.synthetic.main.activity_syllables_listen_practice.*

class SyllablesListenPractice : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_syllables_listen_practice)

        syllables_listen.setOnClickListener {
            startActivity(
                Intent(
                    this,
                    SyllableListen::class.java
                )

            )
        }

        syllables_practice.setOnClickListener {
            startActivity(
                Intent(
                    this,
                    SyllablesPractice::class.java
                )

            )
        }
    }
}