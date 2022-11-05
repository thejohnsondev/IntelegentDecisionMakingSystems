package com.thejohnsondev.intelegentdecisionmakingsystems.home_screen.presentation.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.thejohnsondev.intelegentdecisionmakingsystems.common.util.onClick
import com.thejohnsondev.intelegentdecisionmakingsystems.common.util.openActivity
import com.thejohnsondev.intelegentdecisionmakingsystems.databinding.HomeFragmentBinding
import com.thejohnsondev.intelegentdecisionmakingsystems.lab1.presentation.LabOneActivity

class HomeFragment: Fragment() {

    private val binding by lazy {
        HomeFragmentBinding.inflate(layoutInflater)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initListeners()
    }

    private fun initListeners() = with(binding) {
        btnLab1.onClick {
            openActivity<LabOneActivity>()
        }
        btnLab2.onClick {

        }
        btnLab3.onClick {

        }
    }

}