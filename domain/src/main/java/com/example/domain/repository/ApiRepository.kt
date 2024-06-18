package com.example.domain.repository

import com.example.domain.models.Offer
import com.example.domain.models.Ticket
import com.example.domain.models.TicketOffer


interface ApiRepository {
    suspend fun getOffers(): List<Offer>

    suspend fun getTicketsOffers(): List<TicketOffer>

    suspend fun getTickets(): List<Ticket>
}