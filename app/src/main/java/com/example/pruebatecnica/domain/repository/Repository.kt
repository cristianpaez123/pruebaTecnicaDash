package com.example.pruebatecnica.domain.repository

import com.example.pruebatecnica.iu.model.Routes

interface Repository {
    suspend fun getRoutes(): List<Routes>
    suspend fun getResultLogin(email:String,password:String): Boolean
}