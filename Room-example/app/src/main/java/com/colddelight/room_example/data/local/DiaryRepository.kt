package com.colddelight.room_example.data.local

import com.colddelight.room_example.data.local.dao.DiaryDao
import com.colddelight.room_example.data.local.entity.DiaryEntity

class DiaryRepository (private val diaryDao: DiaryDao){

    suspend fun getDiary(id:Int): DiaryEntity {
        return diaryDao.getDiary(id)
    }
    suspend fun getAllDiary(): List<DiaryEntity>{
        return diaryDao.getAllDiary()
    }
    suspend fun insetDiary(diary: DiaryEntity){
        return diaryDao.insetDiary(diary)
    }
    suspend fun delDiary(id:Int){
        return diaryDao.delDiary(id)
    }
}