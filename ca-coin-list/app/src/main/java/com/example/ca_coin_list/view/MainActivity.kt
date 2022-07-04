package com.example.ca_coin_list.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.viewModels
import com.example.ca_coin_list.R
import com.example.ca_coin_list.base.BaseActivity
import com.example.ca_coin_list.databinding.ActivityMainBinding
import com.example.ca_coin_list.viewmodel.MainViewModel
import com.example.ca_coin_list.widget.utils.ScreenState
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>(R.layout.activity_main) {
    private val mainViewModel by viewModels<MainViewModel>()

    override fun init() {
        binding.activity= this
        observeViewModel()
    }

    fun clickSearchBtn(view: View){
        mainViewModel.getUserRepo(binding.githubNameEditTxt.text.toString())
    }

    private fun observeViewModel(){
        mainViewModel.mutableScreenState.observe(this) {
            Log.d("로그", "$it")
            when (it) {
                ScreenState.RENDER -> Log.d("ff", "observeViewModel: ddd")
                ScreenState.ERROR -> Log.d("fff", "observeViewModel: ")
                else -> Log.d("ddd", "observeViewModel: dddd")
            }
        }

        mainViewModel.eventUserRepo.observe(this) {
            it.map { item ->
                binding.responseTxt.text = item.url
            }
        }
    }
}