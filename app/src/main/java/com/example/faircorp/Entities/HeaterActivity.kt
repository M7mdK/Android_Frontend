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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_heater)
    }

}