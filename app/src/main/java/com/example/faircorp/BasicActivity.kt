package com.example.faircorp

import android.content.Intent
import android.net.Uri
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.example.faircorp.Lists.BuildingsActivity
import com.example.faircorp.Lists.HeatersActivity
import com.example.faircorp.Lists.RoomsActivity
import com.example.faircorp.Lists.WindowsActivity

open class BasicActivity : AppCompatActivity() {

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.menu_buildings -> startActivity(
                Intent(this, BuildingsActivity::class.java)
            )
            R.id.menu_rooms -> startActivity(
                Intent(this, RoomsActivity::class.java)
            )
            R.id.menu_windows -> startActivity(
                Intent(this, WindowsActivity::class.java)
            )
            R.id.menu_heaters -> startActivity(
                Intent(this, HeatersActivity::class.java)
            )
            R.id.menu_website -> startActivity(
                Intent(Intent.ACTION_VIEW, Uri.parse("https://dev-mind.fr"))
            )
            R.id.menu_github -> startActivity(
                Intent(Intent.ACTION_SENDTO, Uri.parse("https://github.com/M7mdK"))
            )
            R.id.menu_linkedin -> startActivity(
                Intent(Intent.ACTION_VIEW, Uri.parse("https://www.linkedin.com/in/mohamad-kassem-6950231b1/"))
            )
            R.id.menu_email -> startActivity(
                Intent(Intent.ACTION_VIEW, Uri.parse("mailto://mohammad.kassem.1999@hotmail.com"))
            )

        }
        return super.onContextItemSelected(item)
    }
}