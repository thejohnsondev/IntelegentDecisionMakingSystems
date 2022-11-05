package com.thejohnsondev.intelegentdecisionmakingsystems.lab1.presentation.view_model

import androidx.lifecycle.ViewModel
import com.github.adriankuta.datastructure.tree.TreeNode
import com.thejohnsondev.intelegentdecisionmakingsystems.common.util.emptyTree
import com.thejohnsondev.intelegentdecisionmakingsystems.lab1.domain.repository.CarRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import javax.inject.Inject

@HiltViewModel
class CarViewModel @Inject constructor(
    private val carRepository: CarRepository
) : ViewModel() {

    val firstStepChoice = MutableStateFlow(emptyTree())
    val secondStepChoice = MutableStateFlow(emptyTree())
    val thirdStepChoice = MutableStateFlow(emptyTree())

    suspend fun getCarTree(): Flow<TreeNode<String>> {
        return carRepository.getCarTree()
    }

}