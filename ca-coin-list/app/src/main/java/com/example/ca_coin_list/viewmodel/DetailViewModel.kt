package com.example.ca_coin_list.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ca_coin_list.model.DetailPresentationCoin
import com.example.ca_coin_list.usecase.GetCoinDetailUseCase
import com.example.ca_coin_list.usecase.GetCoinUseCase
import com.example.ca_coin_list.utils.State
import com.example.domain.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val useCase: GetCoinDetailUseCase
):ViewModel(){
    data class CoinDetailState(
        val state: State = State.LOADING,
        val data: DetailPresentationCoin? = null,
        val error: String = ""
    )
    private val _coinDetailState = MutableStateFlow(CoinDetailState())
    val coinDetailState: StateFlow<CoinDetailState> = _coinDetailState.asStateFlow()

    fun getCoinDetails(id:String){
        useCase(id).onEach { result ->
            when (result) {
                is Resource.Loading -> {
                    _coinDetailState.value = CoinDetailState()
                }
                is Resource.Success -> {
                    _coinDetailState.value = CoinDetailState(
                        state = State.SUCCESS,
                        error = "",
                        data = result.data
                    )
                }
                is Resource.Error -> {
                    _coinDetailState.value = CoinDetailState(
                        state = State.ERROR,
                        error = result.message,
                        data = null
                    )
                }
            }
        }.launchIn(viewModelScope)
    }
}

