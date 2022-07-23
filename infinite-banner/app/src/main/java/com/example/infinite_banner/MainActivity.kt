package com.example.infinite_banner

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.infinite_banner.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initEvent()
    }

    private fun initEvent() {
        binding.banner.setOnClickListener {
            val intervalTime = binding.editTextNumber.text.toString()
            val intent = Intent(this@MainActivity, InfiniteBannerActivity::class.java)
            intent.putExtra("intervalTime", intervalTime.toLong()*1000);
            startActivity(intent);
//            startActivity(Intent(this, InfiniteBannerActivity::class.java))
        }
    }
}