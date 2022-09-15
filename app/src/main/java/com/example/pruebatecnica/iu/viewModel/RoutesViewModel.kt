package com.example.pruebatecnica.iu.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pruebatecnica.domain.RouteUC
import com.example.pruebatecnica.iu.model.Routes
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers

import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RoutesViewModel @Inject constructor(
    private val routeUC: RouteUC
) : ViewModel()  {

    //private val routeUC: RouteUC = RouteUC()
    private val dataRoutes: MutableLiveData<Routes> = MutableLiveData()
    fun getDataRoutesState(): LiveData<Routes> = dataRoutes



    fun getDataRoute(){
        viewModelScope.launch (Dispatchers.IO){
            val dataRoute = routeUC.getDataRoute()
            Log.i("cristian", dataRoute.toString())
        }
    }
}