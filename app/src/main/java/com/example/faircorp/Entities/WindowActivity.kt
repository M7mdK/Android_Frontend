package com.example.faircorp.Entities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import com.example.faircorp.APIs.ApiServices
import com.example.faircorp.BasicActivity
import com.example.faircorp.R
import com.example.faircorp.WINDOW_NAME_PARAM
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class WindowActivity : BasicActivity() {

    var id: Long = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_window)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        id = intent.getLongExtra(WINDOW_NAME_PARAM, 0)

        lifecycleScope.launch(context = Dispatchers.IO) {
            runCatching { ApiServices().windowApiService.findById(id).execute() }
                .onSuccess {
                    withContext(context = Dispatchers.Main) {
                        findViewById<TextView>(R.id.window_name_text_window).text = it.body()?.name
                        findViewById<TextView>(R.id.window_room_name_text_window).text = it.body()?.roomName
                        findViewById<TextView>(R.id.window_status_text_window).text = it.body()?.windowStatus.toString()

                        lifecycleScope.launch(context = Dispatchers.IO) {
                            runCatching {
                                ApiServices().roomApiService.findById(it.body()?.roomId).execute()
                            }
                                .onSuccess {
                                    withContext(context = Dispatchers.Main) {
                                        findViewById<TextView>(R.id.window_current_temp_text_window).text = it.body()?.currentTemperature?.toString()
                                        findViewById<TextView>(R.id.window_target_temp_text_window).text = it.body()?.targetTemperature?.toString()
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

    fun switchWindowStatus(view: View) {
        lifecycleScope.launch(context = Dispatchers.IO) {
            runCatching { ApiServices().windowApiService.switchStatus(id).execute() }
        }
    }
}