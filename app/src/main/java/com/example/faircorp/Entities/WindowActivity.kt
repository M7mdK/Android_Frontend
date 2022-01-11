package com.example.faircorp.Entities

import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import com.example.faircorp.BasicActivity
import com.example.faircorp.APIs.ApiServices
import com.example.faircorp.R
import com.example.faircorp.WINDOW_NAME_PARAM
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class WindowActivity : BasicActivity() {

    val id = intent.getLongExtra(WINDOW_NAME_PARAM, 0)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_window)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        lifecycleScope.launch(context = Dispatchers.IO) {
            runCatching { ApiServices().windowsApiService.findById(id).execute() }
                .onSuccess {
                    withContext(context = Dispatchers.Main) {
                        findViewById<TextView>(R.id.txt_window_name).text = it.body()?.name
                        findViewById<TextView>(R.id.txt_room_name).text = it.body()?.room?.name
                        findViewById<TextView>(R.id.txt_window_status).text = it.body()?.status.toString()
                        lifecycleScope.launch(context = Dispatchers.IO) {
                            runCatching {
                                ApiServices().roomApiService.findById(it.body()?.room?.id).execute()
                            }
                                .onSuccess {
                                    withContext(context = Dispatchers.Main) {
                                        findViewById<TextView>(R.id.txt_window_target_temperature).text = it.body()?.targetTemperature?.toString()
                                    }
                                }
                                .onFailure {
                                    withContext(context = Dispatchers.Main) {
                                        Toast.makeText(
                                            applicationContext,
                                            "Error on Temperatures loading $it",
                                            Toast.LENGTH_LONG
                                        ).show()
                                    }
                                }
                        }
                    }
                }
                .onFailure {
                    withContext(context = Dispatchers.Main) {
                        Toast.makeText(
                            applicationContext,
                            "Error on window loading $it",
                            Toast.LENGTH_LONG
                        ).show()
                    }
                }

        }
    }

    fun switchStatus(view: View) {
        lifecycleScope.launch(context = Dispatchers.IO) {
            runCatching { ApiServices().windowsApiService.switchStatus(id).execute() }
        }
    }
}