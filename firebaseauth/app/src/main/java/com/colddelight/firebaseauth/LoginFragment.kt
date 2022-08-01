package com.colddelight.firebaseauth

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.colddelight.firebaseauth.databinding.FragmentHomeBinding
import com.colddelight.firebaseauth.databinding.FragmentLoginBinding

class LoginFragment : Fragment(R.layout.fragment_home) {
    lateinit var binding: FragmentLoginBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLoginBinding.inflate(layoutInflater,container,false)
        val mActivity = activity as MainActivity

        binding.loginBtn.setOnClickListener{
            mActivity.signInGoogle()
        }
        return binding.root
    }

}