package com.kevicsalazar.uplabs.travelguide.data.di

import com.kevicsalazar.uplabs.travelguide.data.network.Api
import com.kevicsalazar.uplabs.travelguide.data.network.utils.createOkHttpClient
import com.kevicsalazar.uplabs.travelguide.data.network.utils.createRetrofit
import com.kevicsalazar.uplabs.travelguide.data.repository.CategoriesDataRepository
import com.kevicsalazar.uplabs.travelguide.data.repository.SpotsDataRepository
import com.kevicsalazar.uplabs.travelguide.domain.repository.CategoriesRepository
import com.kevicsalazar.uplabs.travelguide.domain.repository.SpotsRepository
import org.koin.dsl.module
import retrofit2.Retrofit

const val HOST = "https://next.json-generator.com/"

val dataModule = module {

    // Network

    single { createRetrofit(createOkHttpClient(), HOST) }
    single { get<Retrofit>().create(Api::class.java) }

    // Repositories

    factory<CategoriesRepository> { CategoriesDataRepository(get()) }
    factory<SpotsRepository> { SpotsDataRepository(get()) }

}

