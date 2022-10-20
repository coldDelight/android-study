package com.colddelight.room_example.data.local.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import com.colddelight.room_example.data.local.model.HabitAndDiary

@Dao
interface HabitAndDiaryDao {
    @Transaction
    @Query("SELECT * from habit")
    suspend fun getAllHabitAndDiary():List<HabitAndDiary>

    @Transaction
    @Query("SELECT * from diary WHERE habit_id=:habit_id")
    suspend fun getHabitAndDiary(habit_id:Int):HabitAndDiary
}