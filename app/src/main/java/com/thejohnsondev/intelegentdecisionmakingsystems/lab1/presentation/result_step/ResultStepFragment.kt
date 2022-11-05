package com.thejohnsondev.intelegentdecisionmakingsystems.lab1.presentation.result_step

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.github.adriankuta.datastructure.tree.TreeNode
import com.thejohnsondev.intelegentdecisionmakingsystems.R
import com.thejohnsondev.intelegentdecisionmakingsystems.databinding.ResultStepFragmentLayoutBinding
import com.thejohnsondev.intelegentdecisionmakingsystems.lab1.presentation.view_model.CarViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class ResultStepFragment: Fragment() {

    private val binding by lazy {
        ResultStepFragmentLayoutBinding.inflate(layoutInflater)
    }
    private lateinit var viewModel: CarViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        initViewModel()
        return binding.root
    }

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initListeners()
    }

    private fun initViewModel() {
        viewModel = ViewModelProvider(requireActivity())[CarViewModel::class.java]
    }

    @RequiresApi(Build.VERSION_CODES.M)
    private fun initListeners() {
        lifecycleScope.launch {
            viewModel.thirdStepChoice.collect(::initUserOptions)
        }
    }

    @RequiresApi(Build.VERSION_CODES.M)
    private fun initUserOptions(tree: TreeNode<String>) {
        binding.tvDescription.text = getString(R.string.best_choice, tree.children.first().value)
    }

}