package com.example.domain.models


data class Ticket(
    val id: Long,
    val badge: String,
    val price: Price,
    val providerName: String,
    val company: String,
    val departure: Info,
    val arrival: Info,
    val hasTransfer: Boolean,
    val hasVisaTransfer: Boolean,
    val luggage: Luggage,
    val handLuggage: HandLuggage,
    val isReturnable: Boolean,
    val isExchangeable: Boolean
)


data class Luggage(
    val hasLuggage: Boolean,
    val price: Price
)

data class Info(
    val town: String,
    val date: String,
    val airport: String
)


data class HandLuggage(
    val hasHandLuggage: Boolean,
    val size: String
)
