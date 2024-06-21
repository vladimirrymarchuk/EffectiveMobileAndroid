package com.example.data.repository

import com.example.data.service.SharedPrefService
import com.example.domain.repository.SharedPrefRepository

class SharedPrefRepositoryImpl(private val service: SharedPrefService): SharedPrefRepository {
    override fun getPlaceA(): String? = service.getPlaceA()

    override fun savePlaceA(text: String) = service.savePlaceA(text)
}