package com.example.domain.models

import com.google.gson.annotations.SerializedName
import java.sql.Time
import java.util.Date


data class TicketOffer(
    @SerializedName("id") val id: Long,
    @SerializedName("title") val title: String,
    @SerializedName("time_range")val timeRange: List<String>,
    @SerializedName("price") val price: Price
)