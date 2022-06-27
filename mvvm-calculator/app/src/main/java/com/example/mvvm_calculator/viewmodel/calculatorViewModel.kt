package com.example.mvvm_calculator.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mvvm_calculator.data.repository.CalculatorRepository

class CalculatorViewModel():ViewModel() {
    val TAG = "MainViewModel"
    private var count = 2
    val countText : MutableLiveData<String> = MutableLiveData()

    fun init() {
        Log.d(TAG, "## MainViewModel - init!!")
        countText.value = "click count : $count"
    }
    fun clickButton() {
        Log.d(TAG, "## MainViewModel - click!!")

        countText.value = "click count : ${++count}"
    }
    override fun onCleared() {
        Log.d(TAG, "## MainViewModel - onCleared() called!!")
        Log.d(TAG, "## count = $count")
        super.onCleared()
    }
    //private 추가
//    var count = MutableLiveData<Int>()
//     var liveText: MutableLiveData<String> = MutableLiveData()


     var _resVar : MutableLiveData<String> =  MutableLiveData("200,00")
    var resVar :  LiveData<String> = _resVar
     var _inputVar: MutableLiveData<String> =  MutableLiveData("20")
    var inputVar : LiveData<String> =  _inputVar





    fun btnClicked(str:String){
        _inputVar.value =  _inputVar.value.plus(str)
    }




}