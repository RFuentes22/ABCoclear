package com.coclearapp.pdm_project.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.coclearapp.pdm_project.Models.Animal
import com.coclearapp.pdm_project.Models.Vowel
import com.coclearapp.pdm_project.R

class VowelAdapter(var context: Context, var arrayList: ArrayList<Vowel>):RecyclerView.Adapter<VowelAdapter.ItemHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        val itemHolder = LayoutInflater.from(parent.context).inflate(R.layout.grid_vowel_list_item,parent,false)
        return VowelAdapter.ItemHolder(itemHolder)
    }

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        var animals: Vowel = arrayList.get(position)

        holder.icons.setImageResource(animals.iconsVowel!!)
    }

    override fun getItemCount(): Int {
        return arrayList.size
    }

    class ItemHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        var icons = itemView.findViewById<ImageView>(R.id.icons_image)
    }
}