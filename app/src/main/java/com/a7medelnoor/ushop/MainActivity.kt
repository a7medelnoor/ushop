package com.a7medelnoor.ushop

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
       setupNav()
    }

    private fun setupNav() {
        val navController = findNavController(R.id.navHostFragment)
        findViewById<BottomNavigationView>(R.id.bottomNavigationView)
            .setupWithNavController(navController)

        navController.addOnDestinationChangedListener { _, destination, _ ->
            when (destination.id) {
                R.id.homeFragment -> showBottomNav()
                R.id.storeFragment -> showBottomNav()
                R.id.advertisementsFragment -> showBottomNav()
                R.id.notificationsFragment -> showBottomNav()
                R.id.profileFragment -> showBottomNav()
                else  -> hideBottomNav()
            }
        }
    }

    private fun showBottomNav() {
        val bottomNavigation = findViewById<BottomNavigationView>(R.id.bottomNavigationView)
        bottomNavigation.visibility = View.VISIBLE

    }

    private fun hideBottomNav() {
        val bottomNavigation = findViewById<BottomNavigationView>(R.id.bottomNavigationView)
        bottomNavigation.visibility = View.GONE
    }

}