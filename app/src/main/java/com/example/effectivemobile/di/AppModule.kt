package com.example.effectivemobile.di

import com.example.effectivemobile.ui.airtikets.main.AirTicketsViewModel
import com.example.effectivemobile.ui.airtikets.allTickets.AllTicketsViewModel
import com.example.effectivemobile.ui.airtikets.search.SearchViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel { AirTicketsViewModel(get(), get(), get()) }
    viewModel { SearchViewModel(get()) }
    viewModel { AllTicketsViewModel(get()) }
}