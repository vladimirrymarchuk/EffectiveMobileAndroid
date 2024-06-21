package com.example.domain.usecase

import com.example.domain.repository.SharedPrefRepository

class GetPlaceAUseCase(private val repository: SharedPrefRepository) {

    operator fun invoke() = repository.getPlaceA()
}