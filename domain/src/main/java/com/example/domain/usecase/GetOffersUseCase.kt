package com.example.domain.usecase

import com.example.domain.repository.ApiRepository

class GetOffersUseCase(private val repository: ApiRepository) {

    suspend operator fun invoke() = repository.getOffers()

}