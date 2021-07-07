package com.coclearapp.pdm_project.Adapters

import android.content.Context
import android.media.MediaPlayer
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.coclearapp.pdm_project.Models.Syllable
import com.coclearapp.pdm_project.R

class SyllableAdapter(var context: Context, var arrayList: ArrayList<Syllable>): RecyclerView.Adapter<SyllableAdapter.ItemHolder>() {
    var mMediaPlayer: MediaPlayer? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SyllableAdapter.ItemHolder {
        val itemHolder = LayoutInflater.from(parent.context).inflate(R.layout.grid_syllable_list_item,parent,false)
        return ItemHolder(itemHolder)
    }

    override fun onBindViewHolder(holder: SyllableAdapter.ItemHolder, position: Int) {
        var syllables:Syllable = arrayList.get(position)

        holder.icons.setImageResource(syllables.iconsSyllable!!)
        holder.icons.setOnClickListener {
            //  Log.i("myTag", instrument.iconsInstrument.toString());
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
                0 -> R.raw.ma
                1 -> R.raw.me
                2 -> R.raw.mi
                3 -> R.raw.mo
                4 -> R.raw.mu
                5 -> R.raw.ama
                6 -> R.raw.ema
                7 -> R.raw.eme
                8 -> R.raw.amo
                9 -> R.raw.mimo
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