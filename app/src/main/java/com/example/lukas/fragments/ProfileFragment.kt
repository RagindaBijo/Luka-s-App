package com.example.lukas.fragments

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import com.example.lukas.LogIn
import com.example.lukas.R
import com.example.lukas.databinding.FragmentProfileBinding
import com.google.firebase.auth.FirebaseAuth


class ProfileFragment:Fragment(R.layout.fragment_profile) {

    private var _binding:FragmentProfileBinding?=null
    private val binding get() = _binding!!

    override fun onResume() {
        super.onResume()
        val genders=resources.getStringArray(R.array.gender)
        val arrayAdapter=ArrayAdapter(requireContext(),R.layout.dropdown_item,genders)
        binding.autoCompleteTextView.setAdapter(arrayAdapter)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding=FragmentProfileBinding.inflate(inflater,container,false)

        _binding!!.logout.setOnClickListener {
            FirebaseAuth.getInstance().signOut()
            val intent=Intent(this@ProfileFragment.requireContext(),LogIn::class.java)
            startActivity(intent)
        }

        return binding.root


    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding=null
    }


}