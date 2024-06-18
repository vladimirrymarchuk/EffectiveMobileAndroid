package com.example.effectivemobile.di

import com.example.effectivemobile.ui.airtikets.AirTicketsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel { AirTicketsViewModel(get()) }
}