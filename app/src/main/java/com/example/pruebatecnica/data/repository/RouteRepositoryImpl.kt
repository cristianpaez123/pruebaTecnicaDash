package com.example.pruebatecnica.data.repository


import android.util.Log
import com.example.pruebatecnica.iu.model.Routes
import com.google.firebase.firestore.FirebaseFirestore
import javax.inject.Inject

class RouteRepositoryImpl @Inject constructor() {

    val listData = mutableListOf<Routes>()

    suspend fun getRoutes() : List<Routes>{
        FirebaseFirestore.getInstance().collection("routes").get().addOnSuccessListener { result ->
            for (route in result){
                val distance = route.getString("distance")
                val name = route.getString("name")
                val route = Routes(distance!!,name!!)
                listData.add(route)
                Log.d("cristian", listData.toString())
            }
        }
        return listData
    }
}