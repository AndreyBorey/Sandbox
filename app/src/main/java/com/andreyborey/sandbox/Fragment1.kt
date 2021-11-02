package com.andreyborey.sandbox

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.NavHostFragment
import com.andreyborey.sandbox.databinding.Fragment1Binding


class Fragment1 : Fragment() {
    private var _binding: Fragment1Binding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = Fragment1Binding.inflate(layoutInflater, container, false)

        val navController = NavHostFragment.findNavController(this)

        binding.buttonToFragment2.setOnClickListener { navController.navigate(R.id.action_fragment1_to_fragment2) }
        binding.buttonToFragment3.setOnClickListener { navController.navigate(R.id.action_fragment1_to_fragment3) }
        binding.buttonToFragment4.setOnClickListener { navController.navigate(R.id.action_fragment1_to_fragment4) }

        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}