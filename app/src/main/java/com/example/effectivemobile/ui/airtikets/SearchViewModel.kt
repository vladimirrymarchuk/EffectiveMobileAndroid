package com.example.effectivemobile.ui.airtikets

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.models.TicketOffer
import com.example.domain.usecase.GetTicketsOffersUseCase
import com.example.effectivemobile.models.TicketOfferItem
import com.example.effectivemobile.models.mapper.asTicketOfferItemList
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class SearchViewModel(private val getTicketsOffersUseCase: GetTicketsOffersUseCase): ViewModel() {
    private val _ticketsOffers = MutableStateFlow<List<TicketOfferItem>>(emptyList())
    val ticketsOffers: StateFlow<List<TicketOfferItem>> = _ticketsOffers

    var placeA = ""
    var placeB = ""

    init {
        loadTicketsOffers()
    }

    private fun loadTicketsOffers() {
        viewModelScope.launch {
            _ticketsOffers.value = getTicketsOffersUseCase().asTicketOfferItemList()
        }
    }
}