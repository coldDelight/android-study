package com.colddelight.base_example

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.colddelight.base_example.databinding.ActivityMainBinding
import com.colddelight.base_example.base.BaseActivity
import com.colddelight.base_example.util.ErrState
import com.colddelight.base_example.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>(
    R.layout.activity_main,
){
    private val viewModel: MainViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        showToast("😀")

//        binding.btnTest.setOnClickListener {
//            viewModel.getPost()
//
//        }
//        lifecycleScope.launchWhenStarted {
//            viewModel.state.collectLatest {
//                if (it.state==ErrState.SUCCESS){
//                    binding.tvMain.text = it.data[0].title
//                }else if(it.state!=ErrState.BEFORE){
//                    binding.tvMain.text = "ERR"
//                    errHandler(it.errMsg,it.state)
//                }
//            }
//        }
    }
    private fun errHandler(msg : String,type : ErrState){
        when (type){
            ErrState.ERROR_TOAST-> showToast(msg)
            ErrState.ERROR_SNACK-> showSnackBar(msg)
            else -> {

            }
        }
    }


    override fun onInitDataBinding() {

    }
}