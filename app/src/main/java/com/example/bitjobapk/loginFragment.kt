package com.example.bitjobapk

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
<<<<<<< HEAD
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import org.w3c.dom.Text
=======
import androidx.navigation.fragment.findNavController
>>>>>>> 9555c7ee115ded7e87df5ff511fbd43eb24322b6


class loginFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_login, container, false)
<<<<<<< HEAD
        val text = view.findViewById<TextView>(R.id.textView5)
        text.setOnClickListener {
=======
        val button = view.findViewById<Button>(R.id.button)
        button.setOnClickListener {
>>>>>>> 9555c7ee115ded7e87df5ff511fbd43eb24322b6
            findNavController().navigate(R.id.action_loginFragment_to_signupFragment)
        }

        return view
    }

}