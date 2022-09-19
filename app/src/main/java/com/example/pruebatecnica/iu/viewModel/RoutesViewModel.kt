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
) : ViewModel() {

    private val dataRoutes: MutableLiveData<GetDataRoutesState> = MutableLiveData()
    fun getDataRoutesState(): LiveData<GetDataRoutesState> = dataRoutes

    fun getDataRoute() {
        val listData = mutableListOf<Routes>()
        viewModelScope.launch(Dispatchers.IO) {
            dataRoutes.postValue(GetDataRoutesState.Loading)
            try {
                val dataRoute = routeUC.getDataRoute()
                Log.d("cristian", dataRoute.toString())
                dataRoute.addOnSuccessListener { result ->
                    for (route in result) {
                        val distance = route.getString("distance") ?: return@addOnSuccessListener
                        val name = route.getString("name") ?: return@addOnSuccessListener
                        val route = Routes(distance, name)
                        listData.add(route)
                    }
                }
                dataRoutes.postValue(GetDataRoutesState.DataLoaded(listData))
            } catch (e: Exception) {
                dataRoutes.postValue(GetDataRoutesState.Error("error"))
                Log.d("cristian", e.toString())
            }
        }
    }

    sealed class GetDataRoutesState() {
        object Loading : GetDataRoutesState()
        data class DataLoaded(val routeResponseResult: List<Routes>) : GetDataRoutesState()
        data class Error(val message: String) : GetDataRoutesState()
    }
}