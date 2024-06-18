package com.example.data.repository

import com.example.data.api.ApiService
import com.example.domain.repository.ApiRepository

class ApiRepositoryImpl(private val apiService: ApiService): ApiRepository {

    override suspend fun getOffers() = apiService.getOffers().offers

    override suspend fun getTicketsOffers() = apiService.getTicketsOffers().ticketsOffers

    override suspend fun getTickets() = apiService.getTickets().tickets


}