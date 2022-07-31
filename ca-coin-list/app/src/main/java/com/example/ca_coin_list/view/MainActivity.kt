package com.example.ca_coin_list.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ca_coin_list.CoinListAdapter
import com.example.ca_coin_list.R
import com.example.ca_coin_list.databinding.ActivityMainBinding
import com.example.ca_coin_list.viewmodel.MainViewModel
import com.example.ca_coin_list.utils.State
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val binding: ActivityMainBinding by lazy {
        DataBindingUtil.setContentView(this, R.layout.activity_main)
    }

    private val model: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        lifecycleScope.launchWhenStarted {
            model.coinListState.collectLatest {
                when (it.state) {
                    State.LOADING -> {
                        binding.loading.visibility = View.VISIBLE
                    }
                    State.SUCCESS -> {
                        binding.loading.visibility = View.GONE
                        CoinListAdapter(it.data).also { adapter ->
                            binding.rv.adapter = adapter
                            binding.rv.layoutManager = LinearLayoutManager(
                                this@MainActivity,
                                LinearLayoutManager.VERTICAL,
                                false
                            )
                        }
                        binding.rv.addItemDecoration(
                            DividerItemDecoration(
                                this@MainActivity,
                                DividerItemDecoration.VERTICAL
                            )
                        )
                    }
                    State.ERROR -> {
                        binding.loading.visibility = View.GONE
                        Toast.makeText(this@MainActivity, it.error, Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }

    }

}