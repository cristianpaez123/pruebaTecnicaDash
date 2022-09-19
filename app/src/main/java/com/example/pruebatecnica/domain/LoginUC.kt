package com.example.pruebatecnica.domain

import com.example.pruebatecnica.domain.repository.Repository
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class LoginUC @Inject constructor(val repository: Repository) {

    suspend fun getResultLogin(email: String, password: String): Task<AuthResult> =
        withContext(Dispatchers.IO) { repository.getResultLogin(email, password) }
}