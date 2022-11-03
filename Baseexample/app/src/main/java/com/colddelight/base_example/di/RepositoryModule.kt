package com.colddelight.base_example.di

import com.colddelight.base_example.repository.PostRepository
import com.colddelight.base_example.repository.PostRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Provides
    @Singleton
    fun providePostRepository(
    ): PostRepository {
        return PostRepositoryImpl()
    }
}