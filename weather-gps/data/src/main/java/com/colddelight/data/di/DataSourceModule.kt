package com.colddelight.data.di

import com.colddelight.data.WeatherDataApiImpl
import com.colddelight.data.remote.WeatherApi
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
    fun provideWeatherDataSource(
        retrofit: Retrofit
    ): WeatherApi {
        return WeatherDataApiImpl(retrofit)
    }

}