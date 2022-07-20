package com.example.ca_coin_list.base

import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.domain.utils.ErrorType
import com.example.domain.utils.RemoteErrorEmitter

abstract class BaseViewModel : ViewModel() ,RemoteErrorEmitter{
    val mutableProgress = MutableLiveData<Int>(View.GONE)
}