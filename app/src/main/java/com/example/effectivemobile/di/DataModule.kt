package com.example.effectivemobile.di

import com.example.data.api.ApiService
import com.example.data.repository.ApiRepositoryImpl
import com.example.domain.repository.ApiRepository
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val dataModule = module {
    single {
        Retrofit.Builder()
            .baseUrl("https://run.mocky.io/v3/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)
    }

    single<ApiRepository> { ApiRepositoryImpl(get()) }
}