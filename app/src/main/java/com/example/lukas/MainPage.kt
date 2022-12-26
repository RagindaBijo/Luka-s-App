package com.example.lukas

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.lukas.databinding.ActivityMainPageBinding
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.firebase.auth.FirebaseAuth

class MainPage : AppCompatActivity() {

    private lateinit var bottomNavigationView:BottomNavigationView
    private lateinit var navController:NavController
    private var num2:Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_page)
        supportActionBar?.hide()

        bottomNavigationView=findViewById(R.id.bottomNavView)
        navController=findNavController(R.id.nav_host_fragment)
        bottomNavigationView.setupWithNavController(navController)

        val num=intent.getStringExtra("NUM")
        if (num != null) {
            if (num.toInt()==1){
                val intent=Intent(this,LogIn::class.java)
                startActivity(intent)
            }
        }

    }
}