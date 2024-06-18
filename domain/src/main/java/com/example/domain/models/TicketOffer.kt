package com.example.domain.models



data class TicketOffer(
    val id: Long,
    val title: String,
    val timeRange: List<String>,
    val price: Price
)