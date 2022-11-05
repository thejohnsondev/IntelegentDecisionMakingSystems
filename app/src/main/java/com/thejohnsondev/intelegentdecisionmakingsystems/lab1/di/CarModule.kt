package com.thejohnsondev.intelegentdecisionmakingsystems.lab1.di

import com.thejohnsondev.intelegentdecisionmakingsystems.lab1.data.CarDataSource
import com.thejohnsondev.intelegentdecisionmakingsystems.lab1.data.repository.CarRepositoryImpl
import com.thejohnsondev.intelegentdecisionmakingsystems.lab1.domain.repository.CarRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object CarModule {

    @Provides
    @Singleton
    fun provideCarDataSource(): CarDataSource = CarDataSource()

    @Provides
    fun provideCarRepository(carDataSource: CarDataSource): CarRepository = CarRepositoryImpl(carDataSource)
}