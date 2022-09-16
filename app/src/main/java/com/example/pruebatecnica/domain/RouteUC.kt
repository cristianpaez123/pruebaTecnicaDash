package com.example.pruebatecnica.domain

import com.example.pruebatecnica.domain.repository.Repository
import com.example.pruebatecnica.iu.model.Routes
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class RouteUC @Inject constructor(private val repository: Repository){

    suspend fun getDataRoute() : List<Routes> = withContext(Dispatchers.IO) { repository.getRoutes()}
}