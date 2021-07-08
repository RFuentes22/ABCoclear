package com.coclearapp.pdm_project.Activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.coclearapp.pdm_project.Adapters.VowelAdapter
import com.coclearapp.pdm_project.Models.Vowel
import com.coclearapp.pdm_project.R

class VowelsListen : AppCompatActivity() {

    private var rexyclerView: RecyclerView? = null
    private var gridLayoutManager: GridLayoutManager?= null
    private var arrayList:ArrayList<Vowel> ?= null
    private var vowelAdapter: VowelAdapter?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_listen)

        rexyclerView = findViewById(R.id.recycler_view_listen)
        gridLayoutManager = GridLayoutManager(applicationContext,2, LinearLayoutManager.VERTICAL,false)
        rexyclerView?.layoutManager = gridLayoutManager
        rexyclerView?.setHasFixedSize(false)
        arrayList = ArrayList()
        arrayList = setDataInList()
        vowelAdapter = VowelAdapter(applicationContext,arrayList!!)
        rexyclerView?.adapter = vowelAdapter
    }

    private fun setDataInList():ArrayList<Vowel>{
        var items:ArrayList<Vowel> = ArrayList()
        items.add(Vowel(R.drawable.a))
        items.add(Vowel(R.drawable.e))
        items.add(Vowel(R.drawable.i))
        items.add(Vowel(R.drawable.o))
        items.add(Vowel(R.drawable.u))

        return items
    }

}