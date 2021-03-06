package com.example.mvvm_calculator

import androidx.appcompat.app.AppCompatActivity

import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.activity.viewModels
import com.example.mvvm_calculator.databinding.ActivityMainBinding
import com.example.mvvm_calculator.dialog.LogDialog
import com.example.mvvm_calculator.viewmodel.CalculatorViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: CalculatorViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.lifecycleOwner = this
        binding.vm = viewModel
        binding.buttonLog.setOnClickListener{
            val test = LogDialog(binding.buttonLog.context)
            Toast.makeText(applicationContext, viewModel.log.value, Toast.LENGTH_LONG).show()
            test.show()
        }

        //하하 이녀석 때문에 안보이는 구나 참고!!!!
//        setContentView(R.layout.activity_main)
    }
}
