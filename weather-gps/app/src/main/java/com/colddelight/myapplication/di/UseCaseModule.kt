package com.colddelight.myapplication.di

import com.colddelight.domain.repository.WeatherRepository
import com.colddelight.myapplication.usecase.WeatherUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UseCasesModule {
    @Provides
    @Singleton
    fun provideWeatherUseCase(
        repository: WeatherRepository
    ): WeatherUseCase {
        return WeatherUseCase(repository)
    }

}