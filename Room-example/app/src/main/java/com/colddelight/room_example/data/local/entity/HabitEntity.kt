package com.colddelight.room_example.data.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity (tableName = "habit")
data class HabitEntity (
    @ColumnInfo(name = "name")val name : String,
    @PrimaryKey(autoGenerate = true) val habit_id: Int=0,
    )