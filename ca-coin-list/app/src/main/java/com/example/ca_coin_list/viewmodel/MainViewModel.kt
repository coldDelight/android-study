package com.example.ca_coin_list.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import com.example.ca_coin_list.usecase.GetCoinUseCase
import androidx.lifecycle.viewModelScope
import com.example.ca_coin_list.model.PresentationCoin
import com.example.domain.Resource

import com.example.ca_coin_list.utils.State
import kotlinx.coroutines.flow.*

@HiltViewModel
class MainViewModel @Inject constructor(
    private val useCase: GetCoinUseCase
): ViewModel() {

    data class CoinListState(
        val state: State = State.LOADING,
        val data: List<PresentationCoin> = emptyList(),
        val error: String = ""
    )

    private val _coinListState = MutableStateFlow(CoinListState())
    val coinListState: StateFlow<CoinListState> = _coinListState.asStateFlow()

    private fun getCoins() {
        useCase().onEach { result ->
            Log.d("test", "getCoins: $result")
            when (result) {
                is Resource.Loading -> {
                    _coinListState.value = CoinListState()
                }
                is Resource.Success -> {
                    _coinListState.value = CoinListState(
                        state = State.SUCCESS,
                        error = "",
                        data = result.data ?: emptyList()
                    )
                }
                is Resource.Error -> {
                    _coinListState.value = CoinListState(
                        state = State.ERROR,
                        error = result.message,
                        data = emptyList()
                    )
                }
            }
        }.launchIn(viewModelScope)
    }

    init {
        getCoins()
    }
}