package com.example.ca_coin_list.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton
import com.example.data.remote.api.CoinApi
import com.example.data.repository.remote.datasource.CoinDataSource
import com.example.data.repository.remote.datasourceImpl.CoinDataSourceImpl
import retrofit2.Retrofit


@Module
@InstallIn(SingletonComponent::class)
object DataSourceModule {
    @Provides
    @Singleton
    fun provideCoinListDataSource(
        retrofit: Retrofit
    ): CoinDataSource {
        return CoinDataSourceImpl(retrofit)
    }
}