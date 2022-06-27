package com.example.mvvm_calculator

import androidx.appcompat.app.AppCompatActivity

import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.activity.viewModels
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.mvvm_calculator.databinding.ActivityMainBinding
import com.example.mvvm_calculator.viewmodel.CalculatorViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel : CalculatorViewModel
    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.apply {
            lifecycleOwner = this@MainActivity
        }
        viewModel = ViewModelProvider(this)[CalculatorViewModel::class.java]
        viewModel.init()
        binding.vm = viewModel

        binding.button0.setOnClickListener(){
            Log.d("hello", "onCreate: dsfsfsdf")
        }


        setContentView(R.layout.activity_main)
    }
}
