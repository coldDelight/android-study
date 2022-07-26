package com.example.ca_coin_list.di

import com.example.data.repository.CoinDetailRepositoryImpl
import com.example.data.repository.CoinRepositoryImpl
import com.example.data.repository.remote.datasource.CoinDataSource
import com.example.data.repository.remote.datasource.CoinDetailDataSource
import com.example.domain.repository.CoinDetailRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton
import com.example.domain.repository.CoinRepository


@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Provides
    @Singleton
    fun provideCoinListRepository(
        coinListDataSource: CoinDataSource
    ): CoinRepository {
        return CoinRepositoryImpl(coinListDataSource)
    }

    @Provides
    @Singleton
    fun provideCoinDetailRepository(
        coinDetailDataSource: CoinDetailDataSource
    ): CoinDetailRepository {
        return CoinDetailRepositoryImpl(coinDetailDataSource)
    }

}