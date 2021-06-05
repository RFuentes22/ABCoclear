package com.coclearapp.pdm_project.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.coclearapp.pdm_project.Models.Instrument
import com.coclearapp.pdm_project.R

class InstrumentAdapter (var context: Context, var arrayList: ArrayList<Instrument>): RecyclerView.Adapter<InstrumentAdapter.ItemHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder{
        val itemHolder = LayoutInflater.from(parent.context).inflate(R.layout.grid_instrument_list_item,parent,false)
        return ItemHolder(itemHolder)
    }

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        var instrument: Instrument = arrayList.get(position)

        holder.icons.setImageResource(instrument.iconsInstrument!!)

        //Hacer funcion para reproducir sonidos
    }

    override fun getItemCount(): Int {
        return arrayList.size
    }

    class ItemHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        var icons = itemView.findViewById<ImageView>(R.id.icons_image)
    }


}