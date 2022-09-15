package com.example.pruebatecnica.domain

import com.example.pruebatecnica.data.repository.RouteRepositoryImpl
import com.example.pruebatecnica.iu.model.Routes
import com.squareup.okhttp.Route
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class RouteUC @Inject constructor(private val repository: RouteRepositoryImpl){

    //private val repository: RouteRepositoryImpl = RouteRepositoryImpl()
    suspend fun getDataRoute() : List<Routes> = withContext(Dispatchers.IO) { repository.getRoutes()}
}