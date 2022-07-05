package com.example.ca_coin_list.di

import com.example.data.repository.CoinRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton
import com.example.data.repository.remote.datasourceImpl.CoinDataSourceImpl
import com.example.domain.repository.CoinRepository


@Module
@InstallIn(SingletonComponent::class)
//Repository 의존성
class RepositoryModule {

    @Provides
    @Singleton
    fun provideMainRepository(
        coinDataSourceImpl: CoinDataSourceImpl
    ): CoinRepository {
        return CoinRepositoryImpl(
            coinDataSourceImpl
        )
    }
}