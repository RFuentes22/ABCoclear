package com.coclearapp.pdm_project.Activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.coclearapp.pdm_project.Adapters.InstrumentAdapter
import com.coclearapp.pdm_project.Models.Instrument
import com.coclearapp.pdm_project.R

class InstrumentsListen : AppCompatActivity() {

    private var rexyclerView:RecyclerView ? = null
    private var gridLayoutManager:GridLayoutManager ?= null
    private var arrayList:ArrayList<Instrument> ?= null
    private var instrumentAdapter:InstrumentAdapter ?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_listen)

        rexyclerView = findViewById(R.id.recycler_view_listen)
        gridLayoutManager = GridLayoutManager(applicationContext,2,LinearLayoutManager.VERTICAL,false)
        rexyclerView?.layoutManager = gridLayoutManager
        rexyclerView?.setHasFixedSize(false)
        arrayList = ArrayList()
        arrayList = setDataInList()
        instrumentAdapter = InstrumentAdapter(applicationContext,arrayList!!)
        rexyclerView?.adapter = instrumentAdapter


    }

    private fun setDataInList(): ArrayList<Instrument>? {
        var items:ArrayList<Instrument> = ArrayList()
        items.add(Instrument(R.drawable.armonica))
        items.add(Instrument(R.drawable.arpa))
        items.add(Instrument(R.drawable.clarinete))
        items.add(Instrument(R.drawable.corno))
        items.add(Instrument(R.drawable.flauta))
        items.add(Instrument(R.drawable.guitarra_electrica))
        items.add(Instrument(R.drawable.pandereta))
        items.add(Instrument(R.drawable.platillos))
        items.add(Instrument(R.drawable.saxofon))
        items.add(Instrument(R.drawable.tambor))
        items.add(Instrument(R.drawable.triangulo))
        items.add(Instrument(R.drawable.trompeta))
        items.add(Instrument(R.drawable.violin))
        items.add(Instrument(R.drawable.xilofon))

        return items
    }

}