package com.example.bitjobapk

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentContainerView
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.bitjobapk.ui.main.EventListFragment
import com.example.bitjobapk.ui.main.ProfileFragment
import com.example.bitjobapk.ui.main.RegisteredEventFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {


    private  lateinit var navController: NavController

    private lateinit var navView : NavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val eventlistFragment = EventListFragment()
        val registeredEventFragment = RegisteredEventFragment()
        val profileFragment = ProfileFragment()
        makeCurrentFragment(eventlistFragment)

        navView.setNavigationItemSelectedListener {
            when (it.itemId){
                R.id.ic_event -> makeCurrentFragment(eventlistFragment)
                R.id.ic_registered_event -> makeCurrentFragment(registeredEventFragment)
                R.id.ic_profile -> makeCurrentFragment(profileFragment)
            }
            true
        }

        val navHostFragment = supportFragmentManager
            .findFragmentById(R.id.fragment) as NavHostFragment
        navController = navHostFragment.navController
    }

    private fun makeCurrentFragment(fragmentContainerView: Fragment) =
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fragment, fragmentContainerView)
            commit()
        }

    override fun onSupportNavigateUp(): Boolean {
        return  navController.navigateUp() ||  super.onSupportNavigateUp()
    }
}