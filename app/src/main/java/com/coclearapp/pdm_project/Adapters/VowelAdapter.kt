package com.coclearapp.pdm_project.Adapters

import android.content.Context
import android.media.MediaPlayer
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.coclearapp.pdm_project.Models.Animal
import com.coclearapp.pdm_project.Models.Vowel
import com.coclearapp.pdm_project.R

class VowelAdapter(var context: Context, var arrayList: ArrayList<Vowel>):RecyclerView.Adapter<VowelAdapter.ItemHolder>() {

    var mMediaPlayer: MediaPlayer? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        val itemHolder = LayoutInflater.from(parent.context).inflate(R.layout.grid_vowel_list_item,parent,false)
        return VowelAdapter.ItemHolder(itemHolder)
    }

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        var animals: Vowel = arrayList.get(position)

        holder.icons.setImageResource(animals.iconsVowel!!)

        holder.icons.setOnClickListener {
            Log.i("myTag", holder.adapterPosition.toString())
            playSound(it, holder.adapterPosition)
        }
    }

    override fun getItemCount(): Int {
        return arrayList.size
    }

    class ItemHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        var icons = itemView.findViewById<ImageView>(R.id.icons_image)
    }

    private fun playSound(view: View, id: Int) {
        stopSound(view)
        val mediaPlayer: MediaPlayer? = MediaPlayer.create(
            context,
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

    private fun stopSound(view: View) {
        if (mMediaPlayer != null && mMediaPlayer!!.isPlaying) {
            mMediaPlayer!!.stop()
            mMediaPlayer!!.release()
            mMediaPlayer = null
        }
    }

}