package com.colddelight.base_example.base

import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Toast
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModelProvider

abstract class BaseActivity<DB : ViewDataBinding,VM: BaseViewModel>(
    @LayoutRes val layoutId: Int,
    private val viewModelClass : Class<VM>
) : AppCompatActivity() {
    private val binding by lazy {
        DataBindingUtil.setContentView(this,layoutId) as DB
    }
    val viewModel by lazy {
        ViewModelProvider(this)[viewModelClass]
    }
    abstract fun onInitDataBinding()
    //abstract fun setObserver()
    //abstract fun setView()
    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        binding.lifecycleOwner = this
        onInitDataBinding()
    }
    protected fun showToast(msg: String) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }

}