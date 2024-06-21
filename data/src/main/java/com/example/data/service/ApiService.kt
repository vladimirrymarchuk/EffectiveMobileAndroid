package com.example.data.service

import com.example.data.models.OffersResponse
import com.example.data.models.TicketsOffersResponse
import com.example.data.models.TicketsResponse
import retrofit2.http.GET

interface ApiService {

    // Не работает Api
    @GET("ad9a46ba-276c-4a81-88a6-c068e51cce3a")
    suspend fun getOffers(): OffersResponse

    // Не работает Api
    @GET("38b5205d-1a3d-4c2f-9d77-2f9d1ef01a4a")
    suspend fun getTicketsOffers(): TicketsOffersResponse

    // Не работает Api
    @GET("c0464573-5a13-45c9-89f8-717436748b69")
    suspend fun getTickets(): TicketsResponse
}