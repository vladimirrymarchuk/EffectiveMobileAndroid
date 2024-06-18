package com.example.data.api

import com.example.data.models.OffersResponse
import com.example.data.models.TicketsOffersResponse
import com.example.data.models.TicketsResponse
import retrofit2.http.GET

interface ApiService {

    @GET("/214a1713-bac0-4853-907c-a1dfc3cd05fd")
    suspend fun getOffers(): OffersResponse

    @GET("/7e55bf02-89ff-4847-9eb7-7d83ef884017")
    suspend fun getTicketsOffers(): TicketsOffersResponse

    @GET("/670c3d56-7f03-4237-9e34-d437a9e56ebf")
    suspend fun getTickets(): TicketsResponse
}