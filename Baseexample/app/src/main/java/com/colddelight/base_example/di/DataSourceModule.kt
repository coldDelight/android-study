package com.colddelight.base_example.di

import com.colddelight.base_example.data.PostDataSource
import com.colddelight.base_example.data.PostDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataSourceModule {
    @Provides
    @Singleton
    fun providePostDataSource(
        retrofit: Retrofit
    ): PostDataSource {
        return PostDataSourceImpl(retrofit)
    }

}