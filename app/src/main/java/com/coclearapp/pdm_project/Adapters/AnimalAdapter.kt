package com.coclearapp.pdm_project.Adapters

import android.content.Context
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
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder{
        val itemHolder = LayoutInflater.from(parent.context).inflate(R.layout.grid_animal_list_item,parent,false)
        return ItemHolder(itemHolder)
    }

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        var animals:Animal = arrayList.get(position)

        holder.icons.setImageResource(animals.iconsAnimal!!)

        //Hacer funcion para reproducir sonidos
    }

    override fun getItemCount(): Int {
        return arrayList.size
    }

    class ItemHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        var icons = itemView.findViewById<ImageView>(R.id.icons_image)
    }
}