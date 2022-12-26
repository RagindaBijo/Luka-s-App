package com.example.lukas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.lukas.databinding.ActivityMainPageBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainPage : AppCompatActivity() {

    private lateinit var bottomNavigationView:BottomNavigationView
    private lateinit var navController:NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_page)
        supportActionBar?.hide()

        bottomNavigationView=findViewById(R.id.bottomNavView)
        navController=findNavController(R.id.nav_host_fragment)
        bottomNavigationView.setupWithNavController(navController)


    }
}