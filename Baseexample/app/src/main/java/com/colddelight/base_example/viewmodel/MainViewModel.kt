package com.colddelight.base_example.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.colddelight.base_example.base.BaseViewModel
import com.colddelight.base_example.data.Post
import com.colddelight.base_example.repository.PostRepository
import com.colddelight.base_example.repository.PostRepositoryImpl
import com.colddelight.base_example.util.ErrState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: PostRepository
    ): BaseViewModel() {
    data class State(
        val data: List<Post> = arrayListOf(),
        val state: ErrState = ErrState.BEFORE,
        val errMsg: String = ""
    )
    private val _state = MutableStateFlow(State())
    val state: StateFlow<State> = _state.asStateFlow()

    fun getPost(){
        viewModelScope.launch {
            runCatching {
                repository.getPost()
            }.onSuccess {
                _state.value = State(data = it, state = ErrState.SUCCESS)
            }.onFailure {
                _state.value = State(state = ErrState.ERROR_SNACK, errMsg =it.toString())
            }
        }
    }
}