package com.colddelight.firebaseauth



import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.colddelight.firebaseauth.databinding.FragmentHomeBinding
import com.google.firebase.auth.FirebaseAuth
import java.io.File

class HomeFragment() : Fragment(R.layout.fragment_home) {
    private val auth : FirebaseAuth = FirebaseAuth.getInstance()
    lateinit var binding: FragmentHomeBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(layoutInflater,container,false)
        binding.uid.text = auth.currentUser?.uid ?: " "
        binding.email.text = auth.currentUser?.email ?: " "
        val mActivity = activity as MainActivity

        binding.logoutBtn.setOnClickListener{
            fbLogOut(mActivity)
        }

        binding.revokeBtn.setOnClickListener{
            fbRevoke(mActivity)
        }
        return binding.root
    }

    private fun fbLogOut(mActivity:MainActivity){
        auth.signOut()
        mActivity.removeCache()
        Toast.makeText(this.context, "logout" , Toast.LENGTH_SHORT).show()
        mActivity.replaceFragment(LoginFragment())
    }

    private fun fbRevoke(mActivity:MainActivity){
        auth.currentUser?.delete()// 성공하면 sign out 도 진행함
        mActivity.removeCache()
        Toast.makeText(this.context, "revoke" , Toast.LENGTH_SHORT).show()
        mActivity.replaceFragment(LoginFragment())
    }



}
