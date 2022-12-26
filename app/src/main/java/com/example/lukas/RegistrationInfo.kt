package com.example.lukas

import android.app.DatePickerDialog
import android.content.Intent
import android.icu.util.Calendar
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.annotation.RequiresApi
import com.example.lukas.databinding.ActivityRegistrationInfoBinding
import com.google.android.material.textfield.TextInputEditText
import java.text.SimpleDateFormat
import java.util.*

class RegistrationInfo : AppCompatActivity() {

    private lateinit var binding:ActivityRegistrationInfoBinding
    private lateinit var date: Button

    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration_info)

        supportActionBar?.hide()
        binding= ActivityRegistrationInfoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        date=binding.regBirthDate
        val firstName=binding.regName
        val lastName=binding.regLastName
        val btnFinish=binding.finihBtn

        val myCalendar=Calendar.getInstance()

        val datePicker=DatePickerDialog.OnDateSetListener { view, year, month, day ->
            myCalendar.set(Calendar.YEAR,year)
            myCalendar.set(Calendar.MONTH,month)
            myCalendar.set(Calendar.DAY_OF_MONTH,day)
            updateLable(myCalendar)
        }

        date.setOnClickListener {
            DatePickerDialog(this,datePicker,myCalendar.get(Calendar.YEAR),myCalendar.get(Calendar.MONTH),myCalendar.get(Calendar.DAY_OF_MONTH)).show()
        }

        btnFinish.setOnClickListener {
            val rFirst=firstName.text.toString()
            val rLast=lastName.text.toString()
            val rDate=date.text.toString()

            val finish= Intent(this,MainPage::class.java)
            startActivity(finish)
            finish()


        }
    }

    @RequiresApi(Build.VERSION_CODES.N)
    private fun updateLable(myCalendar: Calendar) {
        val myFormat="dd-mm-yyyy"
        val sdf=SimpleDateFormat(myFormat, Locale.UK)
        date.setText(sdf.format(myCalendar.time))
    }


}
