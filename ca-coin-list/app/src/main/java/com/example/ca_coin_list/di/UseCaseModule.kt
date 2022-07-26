package com.example.ca_coin_list.di

import com.example.ca_coin_list.usecase.GetCoinDetailUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton
import com.example.domain.repository.CoinRepository
import com.example.ca_coin_list.usecase.GetCoinUseCase
import com.example.domain.repository.CoinDetailRepository

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {
    @Provides
    @Singleton
    fun provideCoinListUseCase(
        repository: CoinRepository
    ): GetCoinUseCase {
        return GetCoinUseCase(repository)
    }

    @Provides
    @Singleton
    fun provideCoinDetailUseCase(
        repository: CoinDetailRepository
    ): GetCoinDetailUseCase {
        return GetCoinDetailUseCase(repository)
    }

}