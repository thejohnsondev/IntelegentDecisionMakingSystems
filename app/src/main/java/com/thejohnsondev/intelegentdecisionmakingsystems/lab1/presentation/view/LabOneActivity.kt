package com.thejohnsondev.intelegentdecisionmakingsystems.lab1.presentation.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import com.thejohnsondev.intelegentdecisionmakingsystems.R

class LabOneActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lab_one)
        initNavController()
    }

    private fun initNavController() {
        val navController = findNavController(R.id.lab_one_nav_host)
        val graph = navController.navInflater.inflate(R.navigation.lab_one_nav_graph)
        navController.setGraph(graph, null)
    }

}