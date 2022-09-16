package com.example.pruebatecnica.iu.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pruebatecnica.databinding.FragmentRoutesBinding
import com.example.pruebatecnica.iu.adapter.RoutesAdapter
import com.example.pruebatecnica.iu.viewModel.RoutesViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RoutesFragment : Fragment() {

    private val viewModel: RoutesViewModel by viewModels()

    private var routeAdapter: RoutesAdapter? = null
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
        setupObserver()
        initRecyclerView()
    }

    fun getDataRoute() {
        viewModel.getDataRoute()
    }

    private fun setupObserver() {
        viewModel.getDataRoutesState().observe(
            viewLifecycleOwner
        ) { state ->
            when (state) {
                is RoutesViewModel.GetDataRoutesState.Loading -> {
                    showLoading()
                }
                is RoutesViewModel.GetDataRoutesState.DataLoaded -> {
                    hideLoading()
                    routeAdapter?.setHero(state.routeResponseResult)
                }
                is RoutesViewModel.GetDataRoutesState.Error -> {
                    state.message
                }
            }
        }
    }

    fun showLoading() {
        binding.progressLoadingData.setVisibility(View.VISIBLE)
    }

    fun hideLoading() {
        binding.progressLoadingData.setVisibility(View.GONE)
    }

    fun initRecyclerView() {
        routeAdapter = RoutesAdapter()
        with(binding.recyclerView) {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL,false)
            adapter = routeAdapter
        }
    }
}