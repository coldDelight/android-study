package com.colddelight.base_example.base

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.snackbar.Snackbar

abstract class BaseFragment<DB:ViewDataBinding,VM:BaseViewModel>(
    @LayoutRes private val layoutId: Int,
    private val viewModelClass : Class<VM>
):Fragment() {
    lateinit var viewModel : VM
    lateinit var binding : DB

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activity.let {
            viewModel = ViewModelProvider(it!!)[viewModelClass]
        }
    }

    abstract fun onInitDataBinding()
    //abstract fun setObserver()
    //abstract fun setView()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater,layoutId,container,false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        onInitDataBinding()
    }
    protected fun showToast(msg: String) {
        Toast.makeText(requireContext(), msg, Toast.LENGTH_SHORT).show()
    }
    protected fun showSnackBar(msg: String) {
        Snackbar.make(binding.root,msg, Snackbar.LENGTH_SHORT).show()
    }

}