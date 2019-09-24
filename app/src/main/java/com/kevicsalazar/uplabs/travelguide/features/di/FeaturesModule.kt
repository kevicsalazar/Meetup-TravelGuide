package com.kevicsalazar.uplabs.travelguide.features.di

import com.kevicsalazar.uplabs.travelguide.features.home.HomeViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val featuresModules = module {

    viewModel { HomeViewModel(get(), get()) }

}