package com.example.ca_coin_list.viewmodel

import androidx.lifecycle.LiveData
import com.example.ca_coin_list.widget.utils.SingleLiveEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import com.example.domain.usecase.GetCoinUseCase
import com.example.ca_coin_list.base.BaseViewModel
import com.example.domain.model.CoinResponse
import androidx.lifecycle.viewModelScope
import com.example.ca_coin_list.widget.utils.ScreenState
import com.example.domain.utils.ErrorType
import kotlinx.coroutines.launch


@HiltViewModel
class MainViewModel @Inject constructor(
    private val getCoinUseCase: GetCoinUseCase
) : BaseViewModel() {
    val eventUserRepo: LiveData<List<CoinResponse>> get() = _eventUserRepo
    private val _eventUserRepo = SingleLiveEvent<List<CoinResponse>>()


    fun getUserRepo(owner: String) = viewModelScope.launch {
        val response = getCoinUseCase.execute(this@MainViewModel,)
        if(response == null) mutableScreenState.postValue(ScreenState.ERROR) else {
            mutableScreenState.postValue(ScreenState.RENDER)
            _eventUserRepo.postValue(response)
        }
    }
}