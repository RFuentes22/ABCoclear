package com.coclearapp.pdm_project.Activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.coclearapp.pdm_project.Adapters.SyllableAdapter
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
        items.add(Syllable(R.drawable.ma))
        items.add(Syllable(R.drawable.me))
        items.add(Syllable(R.drawable.mi))
        items.add(Syllable(R.drawable.mo))
        items.add(Syllable(R.drawable.mu))
        items.add(Syllable(R.drawable.ama))
        items.add(Syllable(R.drawable.ema))
        items.add(Syllable(R.drawable.eme))
        items.add(Syllable(R.drawable.amo))
        items.add(Syllable(R.drawable.mimo))

        return items
    }

}