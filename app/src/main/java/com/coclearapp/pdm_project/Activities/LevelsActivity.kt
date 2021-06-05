package com.coclearapp.pdm_project.Activities

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.coclearapp.pdm_project.ViewModel.LevelViewModel
import com.coclearapp.pdm_project.R
import kotlinx.android.synthetic.main.activity_levels.*


class LevelsActivity : AppCompatActivity() {

    lateinit var viewModelLevel: LevelViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_levels)

        patient_name_levels.text = intent.getStringExtra("name")
        patient_level_levels.text = intent.getStringExtra("level")

        btn_vowels.setOnClickListener {


        }

        btn_animal.setOnClickListener {
/*            startActivity(
                Intent(
                    this,
                    AnimalListen::class.java
                )
            )*/
        }

        btn_instruments.setOnClickListener {
/*            startActivity(
                Intent(
                    this,
                    InstrumentsListen::class.java
                )
            )*/
        }

    }

}