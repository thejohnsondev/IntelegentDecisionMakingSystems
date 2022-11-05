package com.thejohnsondev.intelegentdecisionmakingsystems.lab1.presentation.first_step

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.github.adriankuta.datastructure.tree.TreeNode
import com.thejohnsondev.intelegentdecisionmakingsystems.R
import com.thejohnsondev.intelegentdecisionmakingsystems.databinding.FirstStepFragmentLayoutBinding
import com.thejohnsondev.intelegentdecisionmakingsystems.lab1.domain.util.generateUserChoices
import com.thejohnsondev.intelegentdecisionmakingsystems.lab1.presentation.view_model.CarViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class FirstStepFragment: Fragment() {

    private val binding by lazy {
        FirstStepFragmentLayoutBinding.inflate(layoutInflater)
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
            viewModel.getCarTree().collect(::initUserOptions)
        }
    }

    @RequiresApi(Build.VERSION_CODES.M)
    private fun initUserOptions(tree: TreeNode<String>) {
        tree.children.forEach { treeNode ->
            generateUserChoices(
                context = requireContext(),
                binding.userOptionsFrame,
                treeNode,
            ) { selectedNode ->
                viewModel.firstStepChoice.value = selectedNode
                findNavController().navigate(R.id.secondStepFragment)
            }
        }
    }
}