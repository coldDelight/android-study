package com.colddelight.room_example.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.colddelight.room_example.data.local.entity.HabitEntity

@Dao
interface HabitDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)//같은 ID Replace
    suspend fun insetHabit(habit :HabitEntity)

    @Query("SELECT * FROM habit WHERE habit_id = (:habit_id)")
    suspend fun getHabit(habit_id:Int): HabitEntity

    @Query("SELECT * FROM habit")
    suspend fun getAllHabit():List<HabitEntity>

    @Query("DELETE FROM  habit WHERE habit_id = :habit_id")
    suspend fun delHabit(habit_id: Int)
}