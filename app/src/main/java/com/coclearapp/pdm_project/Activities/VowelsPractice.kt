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

class VowelsPractice : AppCompatActivity() {

    var mMediaPlayer: MediaPlayer? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_vowels_practice)

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
                0 -> R.raw.a
                1 -> R.raw.e
                2 -> R.raw.i
                3 -> R.raw.o
                4 -> R.raw.u

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
    private val itemList: List<Item<Char, Int, Int, Int, Int, Int>> = listOf(
        Item('a', 3,R.drawable.e,R.drawable.i,R.drawable.a,R.raw.a),
        Item('e', 1,R.drawable.e,R.drawable.u,R.drawable.a,R.raw.e),
        Item('i', 2,R.drawable.a,R.drawable.i,R.drawable.o,R.raw.i),
        Item('o', 3,R.drawable.a,R.drawable.i,R.drawable.o,R.raw.o),
        Item('u', 2,R.drawable.e,R.drawable.u,R.drawable.a,R.raw.u)
    )
}