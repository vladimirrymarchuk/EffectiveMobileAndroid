package com.example.data.repository

import android.util.Log
import com.example.data.service.ApiService
import com.example.domain.models.Offer
import com.example.domain.models.TicketOffer
import com.example.domain.repository.ApiRepository
import kotlin.math.log

class ApiRepositoryImpl(private val apiService: ApiService): ApiRepository {

    override suspend fun getOffers(): List<Offer> {
        val res = apiService.getOffers().offers
        Log.i("offers", res.toString())
        return res
    }

    override suspend fun getTicketsOffers(): List<TicketOffer> {
        val res = apiService.getTicketsOffers()
        Log.i("list", res.toString())
        return res.ticketsOffers
    }

    override suspend fun getTickets() = apiService.getTickets().tickets


}