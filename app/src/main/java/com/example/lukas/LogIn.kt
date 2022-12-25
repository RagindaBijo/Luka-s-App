package com.example.lukas


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.view.isEmpty
import com.example.lukas.databinding.ActivityMainBinding
import com.google.firebase.auth.FirebaseAuth
import kotlin.time.measureTimedValue

class LogIn : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar?.hide()
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val email=binding.loginEmail
        val password=binding.loginPassword
        val logInBtn=binding.login
        val signInBtn=binding.signup
        val forgotPassword=binding.forget

        logInBtn.setOnClickListener {

            val rMail=email.text.toString()
            val rPassword=password.text.toString()

            if (rMail.isEmpty()||rPassword.isEmpty()){
                Toast.makeText(this,"Empty!",Toast.LENGTH_SHORT).show()

                return@setOnClickListener
            }

            FirebaseAuth.getInstance()
                .signInWithEmailAndPassword(rMail,rPassword)
                .addOnCompleteListener {task->
                    if (task.isSuccessful){
                        val mainPage=Intent(this,MainPage::class.java)
                        startActivity(mainPage)
                        finish()
                    }else{
                        Toast.makeText(this,"Error!",Toast.LENGTH_SHORT).show()
                    }
                }

        }

        signInBtn.setOnClickListener {
            val intent=Intent(this,SignUp::class.java)
            startActivity(intent)
        }


        forgotPassword.setOnClickListener {
            val forget=Intent(this,ForgotPassword::class.java)
            startActivity(forget)
        }










    }
}