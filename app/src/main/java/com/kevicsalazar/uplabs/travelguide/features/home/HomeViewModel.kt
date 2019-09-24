package com.kevicsalazar.uplabs.travelguide.features.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.kevicsalazar.uplabs.travelguide.domain.constant.Constant.CULTURAL_SPOT
import com.kevicsalazar.uplabs.travelguide.domain.constant.Constant.POPULAR_SPOT
import com.kevicsalazar.uplabs.travelguide.domain.usecases.GetCategoriesUseCase
import com.kevicsalazar.uplabs.travelguide.domain.usecases.GetSpotsUseCase
import com.kevicsalazar.uplabs.travelguide.features.base.BaseViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class HomeViewModel(
    private val getCategoriesUseCase: GetCategoriesUseCase,
    private val getSpotsUseCase: GetSpotsUseCase
) : BaseViewModel() {

    val viewState: LiveData<HomeViewState>
        get() = _viewState

    private val _viewState = MutableLiveData<HomeViewState>()

    fun getCategories() {
        launch(handler) {
            val categories = getCategoriesUseCase.getCategories()
            withContext(Dispatchers.Main) {
                _viewState.value = HomeViewState.ShowCategories(categories)
            }
        }
    }

    fun getSpots() {
        launch(handler) {
            val spots = getSpotsUseCase.getSpots()
            val popularSpots = spots.filter { it.type == POPULAR_SPOT }
            val culturalSpots = spots.filter { it.type == CULTURAL_SPOT }
            withContext(Dispatchers.Main) {
                _viewState.value = HomeViewState.ShowPopularSpots(popularSpots)
                _viewState.value = HomeViewState.ShowCulturalSpots(culturalSpots)
            }
        }
    }

}