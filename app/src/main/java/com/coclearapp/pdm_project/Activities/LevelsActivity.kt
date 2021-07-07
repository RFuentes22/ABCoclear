package com.coclearapp.pdm_project.Activities

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.coclearapp.pdm_project.R
import com.coclearapp.pdm_project.ViewModel.LevelViewModel
import kotlinx.android.synthetic.main.activity_levels.*


class LevelsActivity : AppCompatActivity() {

    lateinit var viewModelLevel: LevelViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_levels)

        patient_name_levels.text = intent.getStringExtra("name")
        patient_level_levels.text = intent.getStringExtra("level")

        back_patients.setOnClickListener{
            onBackPressed()
        }

        btn_vowels.setOnClickListener {
            startActivity(
                Intent(
                    this,
                    VowelsListenPractice::class.java
                )

                )

        }

        btn_animal.setOnClickListener {
            startActivity(
                Intent(
                    this,
                    AnimalsListenPractice::class.java
                )

            )

        }

        btn_instruments.setOnClickListener {
            startActivity(
                Intent(
                    this,
                    InstrumentsListenPractice::class.java
                )

            )

        }

        btn_syllabus.setOnClickListener {
            startActivity(
                Intent(
                    this,
                    SyllablesListenPractice::class.java
                )

            )

        }

    }

}