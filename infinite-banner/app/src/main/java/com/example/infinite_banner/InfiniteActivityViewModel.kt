package com.example.infinite_banner

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class InfiniteActivityViewModel : ViewModel() {
    private val _bannerItemList: MutableLiveData<List<BannerItem>> = MutableLiveData()
    private val _currentPosition: MutableLiveData<Int> = MutableLiveData()

    val bannerItemList: LiveData<List<BannerItem>>
        get() = _bannerItemList

    private val currentPosition: LiveData<Int>
        get() = _currentPosition

    init{
        _currentPosition.value=0
    }

    fun setBannerItems(list: List<BannerItem>) {
        _bannerItemList.value = list
    }

    fun setCurrentPosition(position: Int){
        _currentPosition.value = position
    }

    fun getCurrentPosition() = currentPosition.value

}