package com.kevicsalazar.uplabs.travelguide.di

import android.app.Application
import com.kevicsalazar.uplabs.travelguide.data.di.dataModule
import com.kevicsalazar.uplabs.travelguide.domain.di.domainModule
import com.kevicsalazar.uplabs.travelguide.features.di.featuresModules
import com.kevicsalazar.uplabs.travelguide.utils.listByElementsOf
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.module.Module

internal fun injectModules(app: Application) {
    startKoin {
        androidLogger()
        androidContext(app)
        modules(appModules)
    }
}

private val appModules by lazy {
    listByElementsOf<Module>(
        dataModule,
        domainModule,
        featuresModules
    )
}