package com.colddelight.room_example.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.colddelight.room_example.data.local.entity.DiaryEntity


@Dao
interface DiaryDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insetDiary(answer : DiaryEntity)

    @Query("SELECT * FROM diary WHERE diary_id = (:diary_id)")
    suspend fun getDiary(diary_id:Int): DiaryEntity

    @Query("SELECT * FROM diary")
    suspend fun getAllDiary():List<DiaryEntity>

    @Query("DELETE FROM  diary WHERE diary_id = :diary_id")
    suspend fun delDiary(diary_id: Int)
}