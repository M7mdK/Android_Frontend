package com.example.faircorp.Entities

import android.os.Bundle
import com.example.faircorp.R
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import com.example.faircorp.APIs.ApiServices
import com.example.faircorp.BasicActivity
import com.example.faircorp.WINDOW_NAME_PARAM
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class HeaterActivity : BasicActivity() {

    val id = intent.getLongExtra(WINDOW_NAME_PARAM, 0)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_heater)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        Toast.makeText(
            applicationContext,
            "Id is: " + id,
            Toast.LENGTH_LONG
        ).show()

        lifecycleScope.launch(context = Dispatchers.IO) {
            runCatching { ApiServices().heaterApiService.findById(id).execute() }
                .onSuccess {
                    withContext(context = Dispatchers.Main) {
                        findViewById<TextView>(R.id.heater_name_txt).text = it.body()?.name
                        findViewById<TextView>(R.id.heater_room_name_txt).text = it.body()?.roomName
                        findViewById<TextView>(R.id.heater_status_txt).text = it.body()?.heaterStatus.toString()
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

    /*fun switchStatus(view: View) {
        lifecycleScope.launch(context = Dispatchers.IO) {
            runCatching { ApiServices().heaterApiService.switchStatus(id).execute() }
        }
    }*/

}