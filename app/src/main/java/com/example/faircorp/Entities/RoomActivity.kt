package com.example.faircorp.Entities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.faircorp.APIs.ApiServices
import com.example.faircorp.BasicActivity
import com.example.faircorp.R
import com.example.faircorp.ROOM_NAME_PARAM
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class RoomActivity : BasicActivity(){

        var id: Long = 0

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_room)
            supportActionBar?.setDisplayHomeAsUpEnabled(true)

            id = intent.getLongExtra(ROOM_NAME_PARAM, 0)

            lifecycleScope.launch(context = Dispatchers.IO) {
                runCatching { ApiServices().roomApiService.findById(id).execute() }
                    .onSuccess {
                        withContext(context = Dispatchers.Main) {
                            findViewById<TextView>(R.id.room_name_txt_room).text = it.body()?.name
                            findViewById<TextView>(R.id.floor_name_txt).text = it.body()?.floor.toString()
                            findViewById<TextView>(R.id.txt_room_current_temperature_room).text = it.body()?.currentTemperature.toString()
                            findViewById<TextView>(R.id.txt_room_target_temperature_room).text = it.body()?.targetTemperature.toString()
                        }
                    }
                    .onFailure {
                        withContext(context = Dispatchers.Main) {
                            Toast.makeText(
                                applicationContext,
                                "Error on Heater loading $it",
                                Toast.LENGTH_LONG
                            ).show()
                        }
                    }
            }
        }

    }