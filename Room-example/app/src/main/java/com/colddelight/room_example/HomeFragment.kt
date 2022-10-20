package com.colddelight.room_example

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.colddelight.room_example.databinding.FragmentHomeBinding
import com.colddelight.room_example.databinding.FragmentInfoBinding
import com.colddelight.room_example.presentaion.viewmodel.MainViewModel

class HomeFragment : Fragment() {
    private val mainViewModel:MainViewModel by activityViewModels()

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View{
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnInfo.setOnClickListener {
            Log.e("ff", "onViewCreated: ${mainViewModel.test}", )
            findNavController().navigate(R.id.action_homeFragment_to_infoFragment)
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}