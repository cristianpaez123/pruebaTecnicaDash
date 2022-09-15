package com.example.pruebatecnica.iu.view

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import com.example.pruebatecnica.R
import com.example.pruebatecnica.databinding.FragmentRoutesBinding
import com.example.pruebatecnica.iu.model.Routes
import com.example.pruebatecnica.iu.viewModel.RoutesViewModel
import com.google.firebase.firestore.FirebaseFirestore
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class RoutesFragment : Fragment() {

    //@Inject
    //lateinit var factory: ViewModelProvider.Factory

    private val viewModel: RoutesViewModel by viewModels()


    val listData = mutableListOf<Routes>()

    private var _binding: FragmentRoutesBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentRoutesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getDataRoute()
    }

    fun getDataRoute() {
        viewModel.getDataRoute()
    }

}