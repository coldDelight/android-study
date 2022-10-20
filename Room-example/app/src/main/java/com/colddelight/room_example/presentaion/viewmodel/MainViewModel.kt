package com.colddelight.room_example.presentaion.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.colddelight.room_example.data.local.DiaryRepository
import com.colddelight.room_example.data.local.HabitAndDiaryRepository
import com.colddelight.room_example.data.local.HabitRepository
import com.colddelight.room_example.data.local.entity.DiaryEntity
import com.colddelight.room_example.data.local.entity.HabitEntity
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: HabitRepository,private val hDRepository : HabitAndDiaryRepository,
    private val diaryRepository: DiaryRepository
):ViewModel(){
    val test = "ddd"
    init {
        viewModelScope.launch {

            val data = repository.getAllHabit()

            Log.e("TAG", "$data: ", )
            repository.insetHabit(HabitEntity("1번질문"))
            repository.insetHabit(HabitEntity("2번질문"))
            repository.insetHabit(HabitEntity("3번질문"))

            val dat2 = diaryRepository.getAllDiary()
            Log.e("TAG", "$dat2: ", )


            diaryRepository.insetDiary(DiaryEntity("1번일기",1))
            diaryRepository.insetDiary(DiaryEntity("3번일기",2))




            val allData = hDRepository.getAllHabitAndDiary()
            Log.e("wow", "wow:$allData ", )
        }
    }




}