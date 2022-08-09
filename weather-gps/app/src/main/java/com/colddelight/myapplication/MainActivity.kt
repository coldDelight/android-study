package com.colddelight.myapplication

import android.Manifest
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.lifecycleScope
import com.colddelight.myapplication.databinding.ActivityMainBinding
import com.colddelight.myapplication.presentation.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val model: MainViewModel by viewModels()
    private lateinit var permissionLauncher: ActivityResultLauncher<Array<String>>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        permissionLauncher = registerForActivityResult(
            ActivityResultContracts.RequestMultiplePermissions()
        ) {
            model.getWeatherData()
        }
        permissionLauncher.launch(arrayOf(
            Manifest.permission.ACCESS_FINE_LOCATION,
            Manifest.permission.ACCESS_COARSE_LOCATION
        ))

        ohMyGod(binding.button)
        ohMyGod(binding.button2)
        ohMyGod(binding.button3)
        ohMyGod(binding.button4)
        ohMyGod(binding.button5)
    }

    fun ohMyGod(btn :Button){
        btn.setOnClickListener {
            val intent = Intent(applicationContext, TestActivity::class.java)
            intent.putExtra("city", btn.text);
            startActivity(intent)
        }
    }

    override fun onResume() {
        super.onResume()
        lifecycleScope.launchWhenResumed {
            model.state.collectLatest {
                binding.model = it.weatherData
                if (it.error.isNotEmpty()) {
                    Toast.makeText(this@MainActivity, it.error, Toast.LENGTH_SHORT).show()
                    Log.e(javaClass.simpleName, "onResume: ${it.error}", )
                }
                if (it.isLoading){
                    binding.pr.visibility = View.VISIBLE
                    binding.cl.visibility = View.GONE
                }
                else {
                    binding.pr.visibility = View.GONE
                    binding.cl.visibility = View.VISIBLE
                }
            }
        }
    }
}