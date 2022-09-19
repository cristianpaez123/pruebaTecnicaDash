package com.example.pruebatecnica.domain.repository

import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.firestore.QuerySnapshot

interface Repository {
    suspend fun getRoutes(): Task<QuerySnapshot>
    suspend fun getResultLogin(email:String,password:String): Task<AuthResult>
}