package com.coclearapp.pdm_project.Activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.coclearapp.pdm_project.Adapters.AnimalAdapter
import com.coclearapp.pdm_project.Adapters.SyllableAdapter
import com.coclearapp.pdm_project.Models.Animal
import com.coclearapp.pdm_project.Models.Syllable
import com.coclearapp.pdm_project.R

class SyllableListen : AppCompatActivity() {
    private var rexyclerView: RecyclerView? = null
    private var gridLayoutManager: GridLayoutManager?= null
    private var arrayList:ArrayList<Syllable> ?= null
    private var syllableAdapter: SyllableAdapter?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_listen)

        rexyclerView = findViewById(R.id.recycler_view_listen)
        gridLayoutManager = GridLayoutManager(applicationContext,2, LinearLayoutManager.VERTICAL,false)
        rexyclerView?.layoutManager = gridLayoutManager
        rexyclerView?.setHasFixedSize(false)
        arrayList = ArrayList()
        arrayList = setDataInList()
        syllableAdapter = SyllableAdapter(applicationContext,arrayList!!)
        rexyclerView?.adapter = syllableAdapter

    }

    private fun setDataInList():ArrayList<Syllable>{
        var items:ArrayList<Syllable> = ArrayList()
        items.add(Syllable(R.drawable.a))
        items.add(Syllable(R.drawable.a))
        items.add(Syllable(R.drawable.a))
        items.add(Syllable(R.drawable.a))
        items.add(Syllable(R.drawable.a))
        items.add(Syllable(R.drawable.a))
        items.add(Syllable(R.drawable.a))
        items.add(Syllable(R.drawable.a))
        items.add(Syllable(R.drawable.a))
        items.add(Syllable(R.drawable.a))

        return items
    }

}