package com.example.faircorp

import android.content.Intent
import android.os.Bundle
import android.view.View
import com.example.faircorp.Lists.BuildingsActivity
import com.example.faircorp.Lists.HeatersActivity
import com.example.faircorp.Lists.RoomsActivity
import com.example.faircorp.Lists.WindowsActivity


const val BUILDING_NAME_PARAM = "com.faircorp.buildingname.attribute"
const val ROOM_NAME_PARAM = "com.faircorp.roomname.attribute"
const val WINDOW_NAME_PARAM = "com.faircorp.windowname.attribute"
const val HEATER_NAME_PARAM = "com.faircorp.heatername.attribute"

class MainActivity : BasicActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    fun openBuildingsList(view : View){
        val intent = Intent(this, BuildingsActivity::class.java)
        startActivity(intent)
    }
    fun openRoomsList(view : View){
        val intent = Intent(this, RoomsActivity::class.java)
        startActivity(intent)
    }
    fun openWindowsList(view : View){
        val intent = Intent(this, WindowsActivity::class.java)
        startActivity(intent)
    }
    fun openHeatersList(view : View){
        val intent = Intent(this, HeatersActivity::class.java)
        startActivity(intent)
    }


}