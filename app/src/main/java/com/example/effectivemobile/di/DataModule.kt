package com.example.effectivemobile.di

import com.example.data.service.ApiService
import com.example.data.repository.ApiRepositoryImpl
import com.example.data.repository.SharedPrefRepositoryImpl
import com.example.data.service.SharedPrefService
import com.example.domain.repository.ApiRepository
import com.example.domain.repository.SharedPrefRepository
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
    single<SharedPrefRepository> { SharedPrefRepositoryImpl(get()) }
    single { SharedPrefService(get()) }
}