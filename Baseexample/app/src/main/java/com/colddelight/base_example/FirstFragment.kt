package com.colddelight.base_example

import android.util.Log
import androidx.lifecycle.lifecycleScope
import com.colddelight.base_example.base.BaseFragment
import com.colddelight.base_example.databinding.FragmentFirstBinding
import com.colddelight.base_example.util.ErrState
import com.colddelight.base_example.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest

@AndroidEntryPoint
class FirstFragment : BaseFragment<FragmentFirstBinding,MainViewModel>(
    R.layout.fragment_first,MainViewModel::class.java
) {

    override fun onInitDataBinding() {


        binding.btn.setOnClickListener {
            viewModel.getPost()

        }
        lifecycleScope.launchWhenStarted {
            viewModel.state.collectLatest {
                if (it.state==ErrState.SUCCESS){
                    showSnackBar("성공")
//                    binding.tvMain.text = it.data[0].title
                }else if(it.state!=ErrState.BEFORE){
//                    binding.tvMain.text = "ERR"
                    errHandler(it.errMsg,it.state)
                }
            }
        }
    }

    private fun errHandler(msg : String,type : ErrState){
        when (type){
            ErrState.ERROR_TOAST-> showToast(msg)
            ErrState.ERROR_SNACK-> showSnackBar(msg)
            else -> {

            }
        }
    }

}

