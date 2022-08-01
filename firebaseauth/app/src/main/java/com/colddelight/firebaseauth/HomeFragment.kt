package com.colddelight.firebaseauth

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.colddelight.firebaseauth.databinding.ActivityMainBinding
import com.colddelight.firebaseauth.databinding.FragmentHomeBinding
import com.google.firebase.auth.FirebaseAuth

class HomeFragment() : Fragment(R.layout.fragment_home) {
    private lateinit var auth : FirebaseAuth
    lateinit var binding: FragmentHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(layoutInflater,container,false)
        auth = FirebaseAuth.getInstance()

        binding.uid.text = auth.currentUser?.uid ?: " "
        binding.email.text = auth.currentUser?.email ?: " "
        val mActivity = activity as MainActivity

        binding.logoutBtn.setOnClickListener{
            auth.signOut()
            mActivity.replaceFragment(LoginFragment())
        }

        binding.revokeBtn.setOnClickListener{
            auth.signOut()
            mActivity.replaceFragment(LoginFragment())

        }
        return binding.root
    }


}
