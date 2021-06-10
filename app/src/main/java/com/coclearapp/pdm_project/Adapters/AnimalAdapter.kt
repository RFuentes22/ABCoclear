package com.coclearapp.pdm_project.Adapters

import android.content.Context
import android.media.MediaPlayer
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView
import com.coclearapp.pdm_project.Models.Animal
import com.coclearapp.pdm_project.R
import kotlinx.android.synthetic.main.grid_animal_list_item.view.*

class AnimalAdapter(var context: Context, var arrayList: ArrayList<Animal>):RecyclerView.Adapter<AnimalAdapter.ItemHolder>(){
    var mMediaPlayer: MediaPlayer? = null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder{
        val itemHolder = LayoutInflater.from(parent.context).inflate(R.layout.grid_animal_list_item,parent,false)
        return ItemHolder(itemHolder)
    }

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        var animals:Animal = arrayList.get(position)

        holder.icons.setImageResource(animals.iconsAnimal!!)
        holder.icons.setOnClickListener {
            //  Log.i("myTag", instrument.iconsInstrument.toString());
            Log.i("myTag", holder.adapterPosition.toString());

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
                0 -> R.raw.caballo
                1 -> R.raw.pollito
                2 -> R.raw.gallo
                3 -> R.raw.gato
                4 -> R.raw.oveja
                5 -> R.raw.pato
                6 -> R.raw.perro
                7 -> R.raw.rana
                8 -> R.raw.vaca
                9 -> R.raw.pajaro
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