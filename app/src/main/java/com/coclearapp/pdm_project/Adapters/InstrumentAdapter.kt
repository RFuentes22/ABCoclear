package com.coclearapp.pdm_project.Adapters

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.coclearapp.pdm_project.Models.Instrument
import com.coclearapp.pdm_project.R
import android.media.MediaPlayer

class InstrumentAdapter(var context: Context, var arrayList: ArrayList<Instrument>) :
    RecyclerView.Adapter<InstrumentAdapter.ItemHolder>() {
    var mMediaPlayer: MediaPlayer? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        val itemHolder = LayoutInflater.from(parent.context)
            .inflate(R.layout.grid_instrument_list_item, parent, false)
        return ItemHolder(itemHolder)
    }

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        var instrument: Instrument = arrayList.get(position)

        holder.icons.setImageResource(instrument.iconsInstrument!!)

        holder.icons.setOnClickListener {
            //  Log.i("myTag", instrument.iconsInstrument.toString());
            Log.i("myTag", holder.adapterPosition.toString());

            playSound(it, holder.adapterPosition)
        }
    }

    override fun getItemCount(): Int {
        return arrayList.size
    }

    class ItemHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var icons = itemView.findViewById<ImageView>(R.id.icons_image)
    }

    private fun playSound(view: View, id: Int) {
        stopSound(view)
        val mediaPlayer: MediaPlayer? = MediaPlayer.create(
            context,
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

    private fun stopSound(view: View) {
        if (mMediaPlayer != null && mMediaPlayer!!.isPlaying) {
            mMediaPlayer!!.stop()
            mMediaPlayer!!.release()
            mMediaPlayer = null
        }
    }


}