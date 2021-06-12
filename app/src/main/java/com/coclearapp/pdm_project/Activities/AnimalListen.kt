package com.coclearapp.pdm_project.Activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.coclearapp.pdm_project.Adapters.AnimalAdapter
import com.coclearapp.pdm_project.Models.Animal
import com.coclearapp.pdm_project.R

class AnimalListen : AppCompatActivity() {

    private var rexyclerView:RecyclerView ? = null
    private var gridLayoutManager:GridLayoutManager ?= null
    private var arrayList:ArrayList<Animal> ?= null
    private var animalAdapter:AnimalAdapter ?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_listen)

        rexyclerView = findViewById(R.id.recycler_view_listen)
        gridLayoutManager = GridLayoutManager(applicationContext,2,LinearLayoutManager.VERTICAL,false)
        rexyclerView?.layoutManager = gridLayoutManager
        rexyclerView?.setHasFixedSize(false)
        arrayList = ArrayList()
        arrayList = setDataInList()
        animalAdapter = AnimalAdapter(applicationContext,arrayList!!)
        rexyclerView?.adapter = animalAdapter


    }

    private fun setDataInList():ArrayList<Animal>{
        var items:ArrayList<Animal> = ArrayList()
        items.add(Animal(R.drawable.caballo))
        items.add(Animal(R.drawable.pollito))
        items.add(Animal(R.drawable.gallo))
        items.add(Animal(R.drawable.gato))
        items.add(Animal(R.drawable.oveja))
        items.add(Animal(R.drawable.pato))
        items.add(Animal(R.drawable.perro))
        items.add(Animal(R.drawable.rana))
        items.add(Animal(R.drawable.vaca))
        items.add(Animal(R.drawable.pajaro))

        return items
    }

}