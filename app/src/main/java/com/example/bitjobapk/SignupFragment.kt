package com.example.bitjobapk

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.navigation.fragment.findNavController

class SignupFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //todo migrate to ViewBinding
        val view = inflater.inflate(R.layout.fragment_signup, container, false)

        //todo choose better names for variables!
        val button = view.findViewById<Button>(R.id.btn_signup)
        button.setOnClickListener {
            findNavController().navigate(R.id.action_signupFragment_to_loginFragment)
        }

        val text = view.findViewById<TextView>(R.id.tv_login)
        text.setOnClickListener {
            findNavController().navigate(R.id.action_signupFragment_to_loginFragment)
        }

        return view
    }

}