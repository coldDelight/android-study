package com.colddelight.base_example

import android.os.Bundle
import com.colddelight.base_example.databinding.ActivityMainBinding
import com.colddelight.base_example.base.BaseActivity
import com.colddelight.base_example.viewmodel.MainViewModel

class MainActivity : BaseActivity<ActivityMainBinding,MainViewModel>(
    R.layout.activity_main,
    viewModelClass = MainViewModel::class.java
){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        showToast("😀")
    }


    override fun onInitDataBinding() {

    }
}