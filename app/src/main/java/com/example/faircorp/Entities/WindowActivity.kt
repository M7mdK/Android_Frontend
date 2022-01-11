package com.example.faircorp.Entities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.faircorp.BasicActivity
import com.example.faircorp.R


abstract class WindowActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_window)
    }

}