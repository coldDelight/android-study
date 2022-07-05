package com.example.ca_coin_list.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton
import com.example.data.remote.api.CoinApi
import com.example.data.repository.remote.datasource.CoinDataSource
import com.example.data.repository.remote.datasourceImpl.CoinDataSourceImpl


@Module
@InstallIn(SingletonComponent::class)
//DataSource 관련
class DataSourceImplModule {

    @Provides
    @Singleton
    fun provideMainDataSource(
        coinApi: CoinApi
    ) : CoinDataSource {
        return CoinDataSourceImpl(
            coinApi
        )
    }
}