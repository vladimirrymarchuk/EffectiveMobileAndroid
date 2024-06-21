package com.example.data.models

import com.example.domain.models.TicketOffer
import com.google.gson.annotations.SerializedName

data class TicketsOffersResponse(
   @SerializedName("tickets_offers") val ticketsOffers: List<TicketOffer>
)
