package com.example.ca_coin_list.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton
import com.example.domain.repository.CoinRepository
import com.example.domain.usecase.GetCoinUseCase


@Module
@InstallIn(SingletonComponent::class)
class UseCaseModule {
    @Provides
    @Singleton
    fun provideGetUserRepoUseCase(repository: CoinRepository) = GetCoinUseCase(repository)
}