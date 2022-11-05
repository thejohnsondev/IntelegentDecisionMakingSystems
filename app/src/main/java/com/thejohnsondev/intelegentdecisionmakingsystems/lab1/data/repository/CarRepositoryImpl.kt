package com.thejohnsondev.intelegentdecisionmakingsystems.lab1.data.repository

import com.github.adriankuta.datastructure.tree.TreeNode
import com.thejohnsondev.intelegentdecisionmakingsystems.lab1.data.CarDataSource
import com.thejohnsondev.intelegentdecisionmakingsystems.lab1.domain.repository.CarRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class CarRepositoryImpl @Inject constructor(
    private val carDataSource: CarDataSource
): CarRepository {

    override suspend fun getCarTree(): Flow<TreeNode<String>> {
        return flow {
            emit(carDataSource.getCarQuestionTree())
        }
    }
}