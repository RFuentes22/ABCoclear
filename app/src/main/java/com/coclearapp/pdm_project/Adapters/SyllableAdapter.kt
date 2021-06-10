package com.coclearapp.pdm_project.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.coclearapp.pdm_project.Models.Animal
import com.coclearapp.pdm_project.Models.Syllable
import com.coclearapp.pdm_project.R

class SyllableAdapter(var context: Context, var arrayList: ArrayList<Syllable>): RecyclerView.Adapter<SyllableAdapter.ItemHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SyllableAdapter.ItemHolder {
        val itemHolder = LayoutInflater.from(parent.context).inflate(R.layout.grid_animal_list_item,parent,false)
        return SyllableAdapter.ItemHolder(itemHolder)
    }

    override fun onBindViewHolder(holder: SyllableAdapter.ItemHolder, position: Int) {
        var syllables:Syllable = arrayList.get(position)

        holder.icons.setImageResource(syllables.iconsSyllable!!)
    }

    override fun getItemCount(): Int {
        return arrayList.size
    }

    class ItemHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        var icons = itemView.findViewById<ImageView>(R.id.icons_image)
    }
}