package com.kevicsalazar.uplabs.travelguide.features.base

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

abstract class BaseViewModel : ViewModel(), CoroutineScope {

    private val job = Job()

    override val coroutineContext: CoroutineContext = job + Dispatchers.IO

    val handler = CoroutineExceptionHandler { _, exception ->
        GlobalScope.launch(Dispatchers.Main) {
            onExceptionHandler(exception)
        }
    }

    protected open fun onExceptionHandler(exception: Throwable) = Unit

    override fun onCleared() {
        super.onCleared()
        job.cancel()
    }

}
