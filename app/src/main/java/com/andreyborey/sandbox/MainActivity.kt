package com.andreyborey.sandbox

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.andreyborey.sandbox.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val toolBar = binding.toolbar
        val navDrawer = binding.navView

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.navHostFragment) as NavHostFragment
        navController = navHostFragment.navController
        val appBarConfiguration = AppBarConfiguration(navController.graph, drawerLayout = binding.drawerLayout, )

        navDrawer.setupWithNavController(navController)
        navDrawer.setNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.itemGlobalToFragment1 ->{
                    navController.navigate(R.id.action_global_fragment1)
                }
                R.id.itemGlobalToFragment2 ->{
                    navController.navigate(R.id.action_global_fragment2)
                }
                R.id.itemGlobalToFragment3 ->{
                    navController.navigate(R.id.action_global_fragment3)
                }
                R.id.itemGlobalToFragment4 ->{
                    navController.navigate(R.id.action_global_fragment4)
                }
        }
            binding.drawerLayout.close()
            return@setNavigationItemSelectedListener true
        }

        setSupportActionBar(toolBar)
        toolBar.setupWithNavController(navController, appBarConfiguration)

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.drawer_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.itemGlobalToFragment1 -> {
                navController.navigate(R.id.action_global_fragment1)
            }
            R.id.itemGlobalToFragment2 -> {
                navController.navigate(R.id.action_global_fragment2)
            }
            R.id.itemGlobalToFragment3 -> {
                navController.navigate(R.id.action_global_fragment3)
            }
            R.id.itemGlobalToFragment4 -> {
                navController.navigate(R.id.action_global_fragment4)
            }
        }
        return super.onOptionsItemSelected(item)
    }
}