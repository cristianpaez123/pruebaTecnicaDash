package com.example.pruebatecnica.data.repository


import android.util.Log
import com.example.pruebatecnica.domain.repository.Repository
import com.example.pruebatecnica.iu.model.Routes
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import javax.inject.Inject

class RouteRepositoryImpl @Inject constructor() : Repository {

    val listData = mutableListOf<Routes>()
    var resultLogin = false

    override suspend fun getRoutes(): List<Routes> {
        FirebaseFirestore.getInstance().collection("routes").get().addOnSuccessListener { result ->
            for (route in result) {
                val distance = route.getString("distance")
                val name = route.getString("name")
                val route = Routes(distance!!, name!!)
                listData.add(route)
                Log.d("cristian", listData.toString())
            }
        }
        return listData
    }

    override suspend fun getResultLogin(email :String,password :String): Boolean {
        FirebaseAuth.getInstance()
            .signInWithEmailAndPassword(
                email,
                password
            ).addOnCompleteListener {
                if (it.isSuccessful) {
                    resultLogin = true
                } else {
                    resultLogin = false
                }
            }
        return resultLogin
    }
}