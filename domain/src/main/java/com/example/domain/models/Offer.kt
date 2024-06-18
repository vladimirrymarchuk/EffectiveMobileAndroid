package com.example.domain.models

data class Offer(
    val id: Long,
    val title: String,
    val town: String,
    val price: Price
)
