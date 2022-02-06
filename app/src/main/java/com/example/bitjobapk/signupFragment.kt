package com.example.bitjobapk

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
<<<<<<< HEAD
import android.widget.TextView
=======
>>>>>>> 9555c7ee115ded7e87df5ff511fbd43eb24322b6
import androidx.navigation.fragment.findNavController

class signupFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_signup, container, false)
        val button = view.findViewById<Button>(R.id.button2)
        button.setOnClickListener {
            findNavController().navigate(R.id.action_signupFragment_to_loginFragment)
        }

<<<<<<< HEAD
        val text = view.findViewById<TextView>(R.id.textView5)
        text.setOnClickListener {
            findNavController().navigate(R.id.action_signupFragment_to_loginFragment)
        }

=======
>>>>>>> 9555c7ee115ded7e87df5ff511fbd43eb24322b6
        return view
    }

}