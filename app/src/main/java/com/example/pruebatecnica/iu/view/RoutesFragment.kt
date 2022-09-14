package com.example.pruebatecnica.iu.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.pruebatecnica.databinding.FragmentRoutesBinding
import com.example.pruebatecnica.iu.viewModel.RoutesViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RoutesFragment : Fragment()  {

    private val viewModel: RoutesViewModel by viewModels()

    private var _binding: FragmentRoutesBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentRoutesBinding.inflate(inflater,container,false)
        return binding.root
    }
}