package com.coclearapp.pdm_project.Activities

import android.content.Intent
import android.media.MediaPlayer
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.coclearapp.pdm_project.Models.Item
import com.coclearapp.pdm_project.R
import kotlinx.android.synthetic.main.activity_vowels_practice.*

class SyllablesPractice : AppCompatActivity() {
    var mMediaPlayer: MediaPlayer? = null

    var index = 0
    private val itemList: List<Item<String, Int, Int, Int, Int, Int>> = listOf(
        Item("ma",2,R.drawable.mi,R.drawable.ma,R.drawable.amo,R.raw.ma),
        Item("me",1,R.drawable.me,R.drawable.ma,R.drawable.mi,R.raw.me),
        Item("mi",3,R.drawable.eme,R.drawable.mu,R.drawable.mi,R.raw.mi),
        Item("mo",2,R.drawable.ma,R.drawable.mo,R.drawable.me,R.raw.mo),
        Item("mu",1,R.drawable.mu,R.drawable.ma,R.drawable.mi,R.raw.mu),
        Item("ama",3,R.drawable.eme,R.drawable.mimo,R.drawable.ama,R.raw.ama),
        Item("amo",2,R.drawable.me,R.drawable.amo,R.drawable.mi,R.raw.amo),
        Item("ema",1,R.drawable.ema,R.drawable.ma,R.drawable.mi,R.raw.ema),
        Item("eme",2,R.drawable.ama,R.drawable.eme,R.drawable.mi,R.raw.eme),
        Item("mimo",3,R.drawable.me,R.drawable.ma,R.drawable.mimo,R.raw.mimo),

    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_syllables_practice)

        playSound(index)
        t_answer_a.setImageResource(itemList[index].opc1)
        t_answer_b.setImageResource(itemList[index].opc2)
        t_answer_c.setImageResource (itemList[index].opc3)

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

            t_answer_a.setImageResource(itemList[index].opc1)
            t_answer_b.setImageResource(itemList[index].opc2)
            t_answer_c.setImageResource(itemList[index].opc3)
            playSound(index)
        }

    }

    private fun playSound(id: Int) {
        stopSound()
        val mediaPlayer: MediaPlayer? = MediaPlayer.create(
            applicationContext,
            when (id) {
                0 -> R.raw.ma
                1 -> R.raw.me
                2 -> R.raw.mi
                3 -> R.raw.mo
                4 -> R.raw.mu
                5 -> R.raw.ama
                6 -> R.raw.amo
                7 -> R.raw.ema
                8 -> R.raw.eme
                9 -> R.raw.mimo

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