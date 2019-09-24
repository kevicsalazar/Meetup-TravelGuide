package com.kevicsalazar.uplabs.travelguide.domain.di

import com.kevicsalazar.uplabs.travelguide.domain.usecases.GetCategoriesUseCase
import com.kevicsalazar.uplabs.travelguide.domain.usecases.GetSpotsUseCase
import org.koin.dsl.module

val domainModule = module {

    factory { GetCategoriesUseCase(get()) }
    factory { GetSpotsUseCase(get()) }

}