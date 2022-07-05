package com.example.ca_coin_list.base

import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.ca_coin_list.widget.utils.ScreenState
import com.example.ca_coin_list.widget.utils.SingleLiveEvent
import com.example.domain.utils.ErrorType
import com.example.domain.utils.RemoteErrorEmitter

abstract class BaseViewModel : ViewModel() ,RemoteErrorEmitter{
    val mutableProgress = MutableLiveData<Int>(View.GONE)
    val mutableScreenState = SingleLiveEvent<ScreenState>()
    private val mutableErrorMessage = SingleLiveEvent<String>()
    val mutableSuccessMessage = MutableLiveData<String>()
    private val mutableErrorType = SingleLiveEvent<ErrorType>()


    override fun onError(errorType: ErrorType) {
        mutableErrorType.postValue(errorType)
    }

    override fun onError(msg: String) {
        mutableErrorMessage.postValue(msg)
    }

}