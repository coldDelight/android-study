package com.colddelight.myapplication

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.lifecycleScope
import com.colddelight.myapplication.databinding.ActivityTestBinding
import com.colddelight.myapplication.presentation.viewmodel.TestViewModel
import com.colddelight.myapplication.utils.CityInfo
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest


@AndroidEntryPoint
class TestActivity : AppCompatActivity() {
    private lateinit var binding: ActivityTestBinding
    private val model: TestViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_test)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_test)

        intent.getStringExtra("city")?.let {
            model.getWeatherCityData(it)
            binding.tvTitle.text=it
        }

        lifecycleScope.launchWhenResumed {
            model.state.collectLatest {
                binding.model = it.weatherData
                if (it.error.isNotEmpty()) {
                    Toast.makeText(this@TestActivity, it.error, Toast.LENGTH_SHORT).show()
                    Log.e(javaClass.simpleName, "onResume: ${it.error}")
                }
                if (it.isLoading) binding.pr.visibility = View.VISIBLE
                else binding.pr.visibility = View.GONE
            }
        }
    }
}