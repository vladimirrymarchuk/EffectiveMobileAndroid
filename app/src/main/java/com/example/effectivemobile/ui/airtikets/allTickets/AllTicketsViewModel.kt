package com.example.effectivemobile.ui.airtikets.allTickets

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.usecase.GetTicketsUseCase
import com.example.effectivemobile.models.TicketItem
import com.example.effectivemobile.models.mapper.asTicketItemList
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class AllTicketsViewModel(
    private val getTicketsUseCase: GetTicketsUseCase
) : ViewModel() {

    private val _tickets = MutableStateFlow<List<TicketItem>>(emptyList())
    val tickets: StateFlow<List<TicketItem>> = _tickets

    init {
        loadTickets()
    }

    private fun loadTickets() {
        viewModelScope.launch {
            _tickets.value = getTicketsUseCase().asTicketItemList()
        }
    }
}