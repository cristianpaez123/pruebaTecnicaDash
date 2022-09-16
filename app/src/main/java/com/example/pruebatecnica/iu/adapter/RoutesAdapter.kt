package com.example.pruebatecnica.iu.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.pruebatecnica.databinding.AdapterRoutesBinding
import com.example.pruebatecnica.iu.model.Routes

class RoutesAdapter : RecyclerView.Adapter<RoutesAdapter.RouteHolder>() {

    var dataRoutes: List<Routes> = emptyList()
    fun setHero(dataRoutes: List<Routes>) {
        this.dataRoutes = dataRoutes
        notifyDataSetChanged()
    }

    class RouteHolder(val binding : AdapterRoutesBinding) : RecyclerView.ViewHolder(binding.root){
        fun render(routeResul : Routes){
            binding.txtName.text = routeResul.name
            binding.txtDistance.text = routeResul.distance
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RouteHolder{
        return RouteHolder(AdapterRoutesBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: RouteHolder, position: Int) {
        val route = dataRoutes[position]
        holder.render(route)
    }

    override fun getItemCount(): Int = dataRoutes.size
}