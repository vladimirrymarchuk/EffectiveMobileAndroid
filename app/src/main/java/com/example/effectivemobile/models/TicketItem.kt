package com.example.effectivemobile.models

data class TicketItem(
    val price: String,
    val time: String,
    val airports: List<String>,
    val info: String,
    val comfortable: Boolean
)
