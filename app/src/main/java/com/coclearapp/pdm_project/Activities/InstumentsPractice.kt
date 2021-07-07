package com.coclearapp.pdm_project.Activities

import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import com.coclearapp.pdm_project.Models.Item
import com.coclearapp.pdm_project.R
import kotlinx.android.synthetic.main.activity_instuments_practice.*

class InstumentsPractice : AppCompatActivity() {

    var mMediaPlayer: MediaPlayer? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_instuments_practice)

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

    private fun validar(opc: Int): Boolean {
        return itemList[index].answer == opc
    }

    private fun nextQuestion() {
        if (index + 1 == itemList.size ) { //numero de items
            val intent = Intent(this, LevelsActivity::class.java)
            startActivity(intent)
        } else {
            index++
            icon.setImageResource(itemList[index].icon)
            t_answer_a.text = itemList[index].opc1
            t_answer_b.text = itemList[index].opc2
            t_answer_c.text = itemList[index].opc3
            playSound(index)
        }

    }

    private fun playSound(id: Int) {
        stopSound()
        val mediaPlayer: MediaPlayer? = MediaPlayer.create(
            applicationContext,
            when (id) {
                0 -> R.raw.armonica
                1 -> R.raw.arpa
                2 -> R.raw.clarinete
                3 -> R.raw.corno
                4 -> R.raw.flauta
                5 -> R.raw.guitarra_electrica
                6 -> R.raw.pandereta
                7 -> R.raw.platillos
                8 -> R.raw.saxofon
                9 -> R.raw.tambor
                10 -> R.raw.triangulo
                11 -> R.raw.trompeta
                12 -> R.raw.violin
                13 -> R.raw.xilofon
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


    var index = 0
    private val itemList: List<Item<Int, Int, String, String, String, Int>> = listOf(
        Item(R.drawable.armonica, 2,"Corno","Armonica","Guitarra",R.raw.armonica),
        Item(R.drawable.arpa, 2,"Violin","Arpa","Pandereta",R.raw.arpa),
        Item(R.drawable.clarinete, 3,"Platillos","Saxofon","Clarinete",R.raw.clarinete),
        Item(R.drawable.corno, 1,"Corno","Armonica","Guitarra",R.raw.corno),
        Item(R.drawable.flauta, 1,"Flauta","Saxofon","Xilofon",R.raw.flauta),
        Item(R.drawable.guitarra_electrica, 2,"Corno","Guitarra","Armonica",R.raw.guitarra_electrica),
        Item(R.drawable.pandereta, 2,"Violin","Pandereta","Arpa",R.raw.pandereta),
        Item(R.drawable.platillos, 3,"Tambor","Triangulo","Platillos",R.raw.platillos),
        Item(R.drawable.saxofon, 3,"Flauta","Xilofono","Saxofon",R.raw.saxofon),
        Item(R.drawable.tambor, 1,"Tambor","Triangulo","Platillos",R.raw.tambor),
        Item(R.drawable.triangulo, 3,"Tambor","Platillos","Triangulo",R.raw.triangulo),
        Item(R.drawable.trompeta, 1,"Trompeta","Saxofon","Clarinete",R.raw.trompeta),
        Item(R.drawable.violin, 1,"Violin","Pandereta","Arpa",R.raw.violin),
        Item(R.drawable.xilofon, 3,"Flauta","Saxofon","Xilofon",R.raw.xilofon)
    )
}