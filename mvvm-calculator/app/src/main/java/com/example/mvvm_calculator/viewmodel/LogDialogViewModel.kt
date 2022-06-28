package com.example.mvvm_calculator.viewmodel

import androidx.lifecycle.*
import com.example.mvvm_calculator.data.model.Log

class LogDialogViewModel(): ViewModel() {
    val _allLogData = MutableLiveData<ArrayList<Log>>()
    var allLogData :  LiveData<ArrayList<Log>> = _allLogData


    init{
        _allLogData.value = ArrayList<Log>()
    }

    fun inputLog(log:String){
        _allLogData.value?.add(Log(log))
    }

}