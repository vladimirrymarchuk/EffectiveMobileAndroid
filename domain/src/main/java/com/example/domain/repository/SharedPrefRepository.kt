package com.example.domain.repository

interface SharedPrefRepository {

    fun getPlaceA(): String?

    fun savePlaceA(text: String)
}