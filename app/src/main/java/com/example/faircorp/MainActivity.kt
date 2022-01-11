package com.example.faircorp

import android.content.Intent
import android.os.Bundle
import android.view.View
import com.example.faircorp.Lists.WindowsActivity

const val WINDOW_NAME_PARAM = "com.faircorp.windowname.attribute"

class MainActivity : BasicActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


    }

    /*fun openWindow(view: View) {

        val windowName = findViewById<EditText>(R.id.editText_window_name).text.toString()

        val intent = Intent(this, WindowActivity::class.java).apply {
            putExtra(WINDOW_NAME_PARAM, windowName)
        }
        startActivity(intent)
    }*/

/*
    fun openWindowsList(view : View){
        val intent = Intent(this, WindowsActivity::class.java)
        startActivity(intent)
    }
*/
}