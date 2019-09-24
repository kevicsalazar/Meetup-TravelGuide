package com.kevicsalazar.uplabs.travelguide

import android.app.Application
import com.kevicsalazar.uplabs.travelguide.di.injectModules

class App: Application() {

    override fun onCreate() {
        super.onCreate()
        injectModules(this)
    }

}