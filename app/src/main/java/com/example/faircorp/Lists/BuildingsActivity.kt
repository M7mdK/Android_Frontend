package com.example.faircorp.Lists

import android.os.Bundle
import com.example.faircorp.R
import android.content.Intent
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.faircorp.APIs.ApiServices
import com.example.faircorp.Adapters.BuildingsAdapter
import com.example.faircorp.BUILDING_NAME_PARAM
import com.example.faircorp.BasicActivity
import com.example.faircorp.Listeners.OnBuildingSelectedListener
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class BuildingsActivity : BasicActivity(), OnBuildingSelectedListener {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_buildings)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)


        val recyclerView = findViewById<RecyclerView>(R.id.list_buildings)
        val adapter = BuildingsAdapter(this)

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = adapter

        lifecycleScope.launch(context = Dispatchers.IO) {
            runCatching { ApiServices().buildingApiService.findAll().execute() }
                .onSuccess {
                    withContext(context = Dispatchers.Main) {
                        adapter.update(it.body() ?: emptyList())
                    }
                }
                .onFailure {
                    withContext(context = Dispatchers.Main) {
                        Toast.makeText(
                            applicationContext,
                            "Error on buildings loading $it",
                            Toast.LENGTH_LONG
                        ).show()
                    }
                }
        }
    }

    override fun onBuildingSelected(id: Long) {
        //val intent = Intent(this, BuildingsActivity::class.java).putExtra(BUILDING_NAME_PARAM, id)
        val intent = Intent(this, RoomsActivity::class.java).putExtra(BUILDING_NAME_PARAM, id)
        startActivity(intent)
    }
}