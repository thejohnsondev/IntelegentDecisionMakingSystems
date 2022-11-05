package com.thejohnsondev.intelegentdecisionmakingsystems.lab1.domain.repository

import com.github.adriankuta.datastructure.tree.TreeNode
import kotlinx.coroutines.flow.Flow

interface CarRepository {
    suspend fun getCarTree(): Flow<TreeNode<String>>
}