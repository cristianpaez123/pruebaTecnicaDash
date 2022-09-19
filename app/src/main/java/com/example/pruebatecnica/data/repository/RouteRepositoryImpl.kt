package com.example.pruebatecnica.data.repository

import com.example.pruebatecnica.domain.repository.Repository
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.QuerySnapshot
import javax.inject.Inject

class RouteRepositoryImpl @Inject constructor() : Repository {

    override suspend fun getRoutes(): Task<QuerySnapshot> {
        return FirebaseFirestore.getInstance().collection("routes").get().addOnSuccessListener {
        }
    }

    override suspend fun getResultLogin(email: String, password: String): Task<AuthResult> {
        return FirebaseAuth.getInstance()
            .signInWithEmailAndPassword(
                email, password
            )
    }
}