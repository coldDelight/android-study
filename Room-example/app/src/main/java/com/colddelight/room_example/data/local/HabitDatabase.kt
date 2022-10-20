package com.colddelight.room_example.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.colddelight.room_example.data.local.dao.DiaryDao
import com.colddelight.room_example.data.local.dao.HabitAndDiaryDao
import com.colddelight.room_example.data.local.dao.HabitDao
import com.colddelight.room_example.data.local.entity.DiaryEntity
import com.colddelight.room_example.data.local.entity.HabitEntity

@Database(
    entities = [HabitEntity::class,DiaryEntity::class],
    version = 4
)
abstract class HabitDatabase:RoomDatabase() {
    abstract val habitDao : HabitDao
    abstract val diaryDao : DiaryDao
    abstract val habitAndDiaryDao : HabitAndDiaryDao


}