package com.example.loginactivity

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.loginactivity.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var navController : NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        navController = (supportFragmentManager
            .findFragmentById(R.id.nav_host_fragment) as NavHostFragment).navController

        setupActionBarWithNavController(navController, AppBarConfiguration(
            setOf(
                R.id.profileFragment,
                R.id.calculatorFragment,
                R.id.converterFragment
            )
        )
        )
        binding.bottomNavView.setupWithNavController(navController)

        navController.addOnDestinationChangedListener { _, destination, _ ->
            if (destination.id == R.id.loginFragment ||
                destination.id == R.id.registerFragment
            )
                binding.bottomNavView.visibility = View.GONE
            else {
                binding.bottomNavView.visibility = View.VISIBLE
            }
        }

        fun checkNumber(result:Double):Number{
            return if (result%1.0==0.0){
                result.toInt()
            }else{
                result
            }
        }

    }
}