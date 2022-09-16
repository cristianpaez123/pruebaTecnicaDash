package com.example.pruebatecnica.app.di

import com.example.pruebatecnica.data.repository.RouteRepositoryImpl
import com.example.pruebatecnica.domain.repository.Repository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Singleton
    @Binds
    abstract fun bindRouteReepository(routeReepositoryImpl: RouteRepositoryImpl): Repository

}