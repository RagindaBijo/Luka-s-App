package com.example.lukas.fragments

import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import androidx.fragment.app.Fragment
import com.example.lukas.R

class ProfileFragment:Fragment(R.layout.fragment_profile) {

    private lateinit var text:AutoCompleteTextView

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val genders=resources.getStringArray(R.array.gender)
        val arrayAdapter=ArrayAdapter(requireContext(),R.layout.dropdown_item,genders)


    }
}