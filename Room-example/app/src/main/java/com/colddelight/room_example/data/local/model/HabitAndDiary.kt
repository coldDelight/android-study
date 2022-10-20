package com.colddelight.room_example.data.local.model

import androidx.room.Embedded
import androidx.room.Relation
import com.colddelight.room_example.data.local.entity.DiaryEntity
import com.colddelight.room_example.data.local.entity.HabitEntity

data class HabitAndDiary(
    @Embedded val habit : HabitEntity,
    @Relation(
        parentColumn = "habit_id",
        entityColumn = "habit_id"
    )
    val diary: DiaryEntity?

)