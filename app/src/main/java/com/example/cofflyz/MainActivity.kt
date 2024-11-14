package com.example.cofflyz

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.cofflyz.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Inflate the layout using Data Binding
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Get references to Navigation elements
        val navView: BottomNavigationView = binding.navView

        // Finding NavHostFragment and NavController
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as? NavHostFragment
        val navController = navHostFragment?.navController ?: return // Return if navHostFragment is null

        // Set up AppBar and BottomNavigationView with Navigation Controller
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications
            )
        )

        // Set up ActionBar with Navigation Controller
        setupActionBarWithNavController(navController, appBarConfiguration)

        // Set up BottomNavigationView to interact with NavController
        navView.setupWithNavController(navController)
    }

    // Optional: Override onSupportNavigateUp to handle action bar navigation
    override fun onSupportNavigateUp(): Boolean {
        val navController = (supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as? NavHostFragment)?.navController
        return navController?.navigateUp() ?: super.onSupportNavigateUp()
    }

    override fun onDestroy() {
        super.onDestroy()
        // Clear binding to avoid memory leaks
        // binding = null // Uncomment if you use nullable binding
    }
}