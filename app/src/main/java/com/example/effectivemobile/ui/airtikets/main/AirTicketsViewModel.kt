package com.example.effectivemobile.ui.airtikets.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.usecase.GetOffersUseCase
import com.example.domain.usecase.GetPlaceAUseCase
import com.example.domain.usecase.SavePlaceAUseCase
import com.example.effectivemobile.models.OfferItem
import com.example.effectivemobile.models.mapper.asOfferItemList
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class AirTicketsViewModel(
    private val getOffersUseCase: GetOffersUseCase,
    private val getPlaceAUseCase: GetPlaceAUseCase,
    private val savePlaceAUseCase: SavePlaceAUseCase
) : ViewModel() {
    private val _offers = MutableStateFlow<List<OfferItem>>(emptyList())
    val offers: StateFlow<List<OfferItem>> = _offers

    var placeA = ""

    init {
        getOffers()
        placeA = loadPlaceA()
    }

    private fun getOffers() {
        viewModelScope.launch(Dispatchers.IO) {
            launch {
                _offers.value = getOffersUseCase().asOfferItemList()
           }
        }
    }

    private fun loadPlaceA() = getPlaceAUseCase() ?: ""
    fun savePlaceA() = savePlaceAUseCase(placeA)
 }