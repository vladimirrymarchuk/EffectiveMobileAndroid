package com.example.domain.usecase

import com.example.domain.repository.SharedPrefRepository

class SavePlaceAUseCase(private val repository: SharedPrefRepository) {

    operator fun invoke(text: String) = repository.savePlaceA(text)
}