package com.colddelight.room_example.data.local

import com.colddelight.room_example.data.local.dao.HabitDao
import com.colddelight.room_example.data.local.entity.HabitEntity

class HabitRepository (private val habitDao: HabitDao){
    suspend fun getHabit(id:Int): HabitEntity{
        return habitDao.getHabit(id)
    }
    suspend fun getAllHabit(): List<HabitEntity>{
        return habitDao.getAllHabit()
    }
    suspend fun insetHabit(habit:HabitEntity){
        return habitDao.insetHabit(habit)
    }
    suspend fun delHabit(id:Int){
        return habitDao.delHabit(id)
    }
}