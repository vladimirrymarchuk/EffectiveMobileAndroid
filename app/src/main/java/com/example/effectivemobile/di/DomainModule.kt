package com.example.effectivemobile.di

import com.example.domain.usecase.GetOffersUseCase
import com.example.domain.usecase.GetTicketsOffersUseCase
import com.example.domain.usecase.GetTicketsUseCase
import org.koin.dsl.module
import kotlin.math.sin

val domainModule = module {
    single { GetOffersUseCase(get()) }
    single { GetTicketsUseCase(get())}
    single { GetTicketsOffersUseCase(get()) }
}