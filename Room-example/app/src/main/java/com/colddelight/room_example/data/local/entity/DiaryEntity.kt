package com.colddelight.room_example.data.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "diary",
    foreignKeys = [
        ForeignKey(
            entity = HabitEntity::class,
            parentColumns = ["habit_id"],
            childColumns = ["habit_id"]
        )
    ]
)
data class DiaryEntity (
    @ColumnInfo(name = "name")val name : String,
    @ColumnInfo(name = "habit_id")val habit_id : Int,
    @PrimaryKey(autoGenerate = true) val diary_id: Int=0,


    ){
    fun toX() :String{
        return ""
    }
}