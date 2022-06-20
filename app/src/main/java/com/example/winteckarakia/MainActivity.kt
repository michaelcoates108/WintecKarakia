package com.example.winteckarakia
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import android.os.Handler
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.core.os.postDelayed

import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import com.example.winteckarakia.ui.HomeFragmentDirections


class MainActivity : AppCompatActivity() {

    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment_main) as NavHostFragment
        navController = navHostFragment.findNavController()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId) {
            R.id.action_translate -> {

                true
            }
            R.id.action_opening_one -> {
                true
            }
            R.id.action_opening_two -> {

                true
            }
            R.id.action_blessing -> {

                true
            }
            R.id.action_closing_one -> {

                true
            }
            R.id.action_closing_two -> {

                true
            }
            R.id.action_about_us -> {

                true
            }
            R.id.action_history -> {
                true
            }

            else -> {
                false
            }
        }

    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp() || super.onSupportNavigateUp()

    }

}
