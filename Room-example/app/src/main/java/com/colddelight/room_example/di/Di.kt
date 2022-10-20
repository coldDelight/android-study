package com.colddelight.room_example.di

import android.content.Context
import androidx.room.Room
import com.colddelight.room_example.data.local.DiaryRepository
import com.colddelight.room_example.data.local.HabitAndDiaryRepository
import com.colddelight.room_example.data.local.HabitDatabase
import com.colddelight.room_example.data.local.HabitRepository
import com.colddelight.room_example.data.local.dao.DiaryDao
import com.colddelight.room_example.data.local.dao.HabitAndDiaryDao
import com.colddelight.room_example.data.local.dao.HabitDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class Di {
    @Singleton
    @Provides
    fun provideHabitDatabase(@ApplicationContext context: Context) : HabitDatabase {
        return Room
            .databaseBuilder(
                context,
                HabitDatabase::class.java,
                "HabitDatabase"
            ).fallbackToDestructiveMigration().
            build()
    }
    @Singleton
    @Provides
    fun provideHabitDao(habitDB: HabitDatabase): HabitDao  {
        return habitDB.habitDao
    }

    @Singleton
    @Provides
    fun provideDiaryDao(habitDB: HabitDatabase): DiaryDao  {
        return habitDB.diaryDao
    }
    @Singleton
    @Provides
    fun provideHabitAndDiaryDao(habitDB: HabitDatabase): HabitAndDiaryDao  {
        return habitDB.habitAndDiaryDao
    }


    @Singleton
    @Provides
    fun provideHabitRepository(
        habitDao: HabitDao
    ): HabitRepository {
        return HabitRepository(habitDao)
    }

    @Singleton
    @Provides
    fun provideDiaryRepository(
        diaryDao: DiaryDao
    ): DiaryRepository {
        return DiaryRepository(diaryDao)
    }
    @Singleton
    @Provides
    fun provideHabitAndDiaryRepository(
        habitAndDiaryDao: HabitAndDiaryDao
    ): HabitAndDiaryRepository {
        return HabitAndDiaryRepository(habitAndDiaryDao)
    }



}