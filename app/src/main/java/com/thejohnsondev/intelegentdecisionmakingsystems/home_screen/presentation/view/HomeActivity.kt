package com.thejohnsondev.intelegentdecisionmakingsystems.home_screen.presentation.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import com.thejohnsondev.intelegentdecisionmakingsystems.R

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        initNavController()
    }

    private fun initNavController() {
        val navController = findNavController(R.id.home_nav_host)
        val graph = navController.navInflater.inflate(R.navigation.home_nav_graph)
        navController.setGraph(graph, null)
    }
}