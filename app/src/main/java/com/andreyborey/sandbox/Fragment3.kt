package com.andreyborey.sandbox

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.andreyborey.sandbox.databinding.Fragment3Binding


class Fragment3 : Fragment() {
    private var _binding: Fragment3Binding? = null
    private val binding get() = _binding!!
    lateinit var navController:NavController

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = Fragment3Binding.inflate(inflater, container, false)

        val navHostFragment = activity?.supportFragmentManager?.findFragmentById(R.id.navHostFragment) as NavHostFragment
        navController = navHostFragment.navController

        val buttomNavView = binding.buttomNavView
        buttomNavView.setupWithNavController(navController)

        buttomNavView.setOnItemSelectedListener {   item ->
            when(item.itemId){
                R.id.itemFragment3toFragment2 -> {
                    navController.navigate(R.id.action_fragment3_to_fragment2)
                }

                R.id.itemFragment3toFragment4 -> {
                    navController.navigate(R.id.action_fragment3_to_fragment4)
                }
            }
            return@setOnItemSelectedListener true
        }

        return binding.root
    }




}


