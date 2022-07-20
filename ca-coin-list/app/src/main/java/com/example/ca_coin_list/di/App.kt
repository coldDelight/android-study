package com.example.ca_coin_list.di

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
// 앱 -> 전부 참조
// 도메인 -> ㅇ없
//데이터 도ㅇ메인
@HiltAndroidApp
class App : Application(){
    companion object {
        private lateinit var application: App
        fun getInstance() : App = application
    }

    override fun onCreate(){
        super.onCreate()
        application = this
    }
}