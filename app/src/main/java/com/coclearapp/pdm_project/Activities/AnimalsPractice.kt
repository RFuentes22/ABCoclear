package com.coclearapp.pdm_project.Activities


import android.content.ClipData
import android.content.Intent
import android.media.MediaPlayer
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.coclearapp.pdm_project.Models.Item

import androidx.appcompat.app.AppCompatActivity
import com.coclearapp.pdm_project.R
import kotlinx.android.synthetic.main.activity_instuments_practice.*

class AnimalsPractice : AppCompatActivity() {
    var mMediaPlayer: MediaPlayer? = null
    var index = 0
    val itemList: List<Item<Int,Int,String,String,String,Int>> = listOf(
        Item(R.drawable.caballo,1,"Caballo","Gato","Oveja",R.drawable.caballo),
        Item(R.drawable.elefante,3,"Perro","Pajaro","Elefante",R.drawable.elefante),
        Item(R.drawable.gallo,2,"Gato","Gallo","Vaca",R.drawable.gallo),
        Item(R.drawable.gato,3,"Perro","Elefante","Gato",R.drawable.gato),
        Item(R.drawable.oveja,1,"Oveja","Pato","Gato",R.drawable.oveja),
        Item(R.drawable.pajaro,2,"Perro","Pajaro","Pato",R.drawable.pajaro),
        Item(R.drawable.pato,2,"Caballo","Pato","Gato",R.drawable.pato),
        Item(R.drawable.perro,3,"Vaca","Elefante","Perro",R.drawable.perro),
        Item(R.drawable.pollito,1,"Pollito","Elefante","Gato",R.drawable.pollito),
        Item(R.drawable.rana,2,"Perro","Rana","Vaca",R.drawable.gato),
        Item(R.drawable.vaca,1,"Vaca","Elefante","Rama",R.drawable.gato),
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_animals_practice)

        playSound(index)
        t_answer_a.text = itemList[index].opc1
        t_answer_b.text = itemList[index].opc2
        t_answer_c.text = itemList[index].opc3

        icon.setOnClickListener {
            playSound(index)
        }

        answer_a.setOnClickListener {
            if (validar(1)) {
                nextQuestion()
            } else
                Toast.makeText(this, "Incorrecto", Toast.LENGTH_SHORT).show()
        }
        answer_b.setOnClickListener {
            if (validar(2)) {
                nextQuestion()
            } else
                Toast.makeText(this, "Incorrecto", Toast.LENGTH_SHORT).show()
        }
        answer_c.setOnClickListener {
            if (validar(3)) {
                nextQuestion()
            } else
                Toast.makeText(this, "Incorrecto", Toast.LENGTH_SHORT).show()
        }
    }

    fun validar(opc: Int): Boolean {
        return itemList[index].answer == opc
    }

    fun nextQuestion() {
        if (index + 1 == itemList.size ) { //numero de items
            val intent = Intent(this, LevelsActivity::class.java)
            startActivity(intent)
        } else {
            index++
            icon.setImageResource(itemList[index].icon)
            t_answer_a.text = itemList[index].opc1
            t_answer_b.text = itemList[index].opc2
            t_answer_c.text = itemList[index].opc3

        }

    }

    private fun playSound(id: Int) {
        stopSound()
        val mediaPlayer: MediaPlayer? = MediaPlayer.create(
            applicationContext,
            when (id) {
                0 -> R.raw.caballo
                1 -> R.raw.elefante
                2 -> R.raw.gallo
                3 -> R.raw.gato
                4 -> R.raw.oveja
                5 -> R.raw.pajaro
                6 -> R.raw.pato
                7 -> R.raw.perro
                8 -> R.raw.pollito
                9 -> R.raw.rana
                10 -> R.raw.vaca
                else -> Log.e("No Sound", "Error no sound")
            }
        )
        mediaPlayer?.start()

    }

    private fun stopSound() {
        if (mMediaPlayer != null && mMediaPlayer!!.isPlaying) {
            mMediaPlayer!!.stop()
            mMediaPlayer!!.release()
            mMediaPlayer = null
        }
    }


}