package com.example.mvvm_calculator.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udojava.evalex.Expression
import java.math.BigDecimal
import java.util.*

class CalculatorViewModel():ViewModel() {
    private val _resVar = MutableLiveData<String>()
    var resVar :  LiveData<String> = _resVar
    private val _inputVar = MutableLiveData<String>()
    var inputVar : LiveData<String> =  _inputVar
    init {
        _resVar.value=""
        _inputVar.value=""
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
                val second = opIndex?.let { inputVar.value?.substring(it, inputVar.value!!.length) }?.toInt()

                val opCode = opIndex?.let { inputVar.value?.get(it) }
                val res: Int = when(opCode){
                    '+' -> first!!+second!!
                    '-' -> first!! - second!!
                    '*' ->first!! * second!!
                    '/' -> first!! / second!!
                    else-> -1
                }
                _inputVar.value = ""
                _resVar.value =  res.toString()
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