package com.example.mvvm_calculator.viewmodel

import android.util.Log
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mvvm_calculator.dialog.LogDialog
// 연산자 중복 입력
// . 처리
// 소수점
// 연산자 여러개
// 괄호
// 연산자 우선순위

//MutableLiveData 상속 -> null 안드롤어 ㅇ게
// ENUM !! ! !

// VM context XXX -> 필요한 경우는 ????  can win
class CalculatorViewModel():ViewModel() {
    private val _resVar = MutableLiveData<String>()
    var resVar :  LiveData<String> = _resVar
    private val _inputVar = MutableLiveData<String>()
    var inputVar : LiveData<String> =  _inputVar

    private val _log = MutableLiveData<String>()
    var log : LiveData<String> =  _log
    init {
        _resVar.value=""
        _inputVar.value=""
        _log.value=""
    }


    fun inputNumber(number:Int){
        _inputVar.value =  _inputVar.value.plus("$number")
    }

    fun inputOperator(operator: Int){
        val op:String = when(operator){
            PLUS -> "+"
            MINUS -> "-"
            MULTIPLY -> "*"
            DIVISION -> "/"
            COMMA -> "."
            else-> ""
        }
        _inputVar.value = _inputVar.value.plus(op)
    }

    fun inputResult(){
        var opIndex :Int?=-1
        val opList = listOf<String>("+","-","*","/")
        for (i in opList){
            opIndex = _inputVar.value?.indexOf(i)
            if(opIndex!=-1){
                val first = opIndex?.let { inputVar.value?.substring(0, it) }?.toInt()
                val second = opIndex?.let { inputVar.value?.substring(it+1, inputVar.value!!.length) }?.toInt()
                val opCode = opIndex?.let { inputVar.value?.get(it) }
                val res: Any = when(opCode){
                    '+' -> first!!+second!!
                    '-' -> first!! - second!!
                    '*' ->first!! * second!!
                    '/' -> first!! / second!!
                    else-> -1
                }
                _resVar.value =  res.toString()
                _log.value = _log.value.plus(inputVar.value).plus(" = ").plus(res.toString()).plus("\n")
                _inputVar.value = ""

                return
            }
        }
//        val res:Int = when(opCode){
//            PLUS -> first+second
//            MINUS ->first-second
//            MULTIPLY ->first*second
//            DIVISION -> first/second
//            else-> -1
//        }


    }

    fun clearNumber(){
        _inputVar.value=""
        _resVar.value=""
    }



    companion object {
        const val PLUS = 1
        const val MINUS = 2
        const val MULTIPLY = 3
        const val DIVISION = 4
        const val COMMA = -1
    }

}