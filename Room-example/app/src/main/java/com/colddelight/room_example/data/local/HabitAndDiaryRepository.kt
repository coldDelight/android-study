package com.colddelight.room_example.data.local

import com.colddelight.room_example.data.local.dao.HabitAndDiaryDao
import com.colddelight.room_example.data.local.model.HabitAndDiary

class HabitAndDiaryRepository (private val habitAndDiaryDao: HabitAndDiaryDao){
    suspend fun getHabitAndDiary(id:Int): HabitAndDiary? {
        return habitAndDiaryDao.getHabitAndDiary(id)
    }
    suspend fun getAllHabitAndDiary(): List<HabitAndDiary>? {
        return habitAndDiaryDao.getAllHabitAndDiary()
    }

}