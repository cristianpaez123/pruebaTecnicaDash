package com.example.pruebatecnica.domain

import com.example.pruebatecnica.domain.repository.Repository

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class LoginUC @Inject constructor(val repository: Repository){

    suspend fun getResultLogin(email:String,password:String): Boolean = withContext(Dispatchers.IO) { repository.getResultLogin(email,password) }
}