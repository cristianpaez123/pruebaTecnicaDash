package com.example.pruebatecnica.domain

import com.example.pruebatecnica.domain.repository.Repository
import com.google.android.gms.tasks.Task
import com.google.firebase.firestore.QuerySnapshot
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class RouteUC @Inject constructor(private val repository: Repository){

    suspend fun getDataRoute() : Task<QuerySnapshot> = withContext(Dispatchers.IO) { repository.getRoutes()}
}