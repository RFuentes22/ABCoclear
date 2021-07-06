package com.coclearapp.pdm_project.Activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.coclearapp.pdm_project.R
import kotlinx.android.synthetic.main.activity_animals_listen_practice.*


class AnimalsListenPractice : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_animals_listen_practice)

        animals_listen.setOnClickListener {
            startActivity(
                Intent(
                    this,
                    AnimalListen::class.java
                )

            )
        }

        animals_practice.setOnClickListener{
            startActivity(
                Intent(
                    this,
                    AnimalsPractice::class.java
                )
            )
        }
    }

}