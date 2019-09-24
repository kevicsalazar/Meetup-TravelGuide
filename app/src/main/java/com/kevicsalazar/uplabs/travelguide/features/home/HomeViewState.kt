package com.kevicsalazar.uplabs.travelguide.features.home

import com.kevicsalazar.uplabs.travelguide.domain.entities.Category
import com.kevicsalazar.uplabs.travelguide.domain.entities.Spot

sealed class HomeViewState {

    class ShowCategories(val categories: List<Category>) : HomeViewState()

    class ShowPopularSpots(val spots: List<Spot>) : HomeViewState()

    class ShowCulturalSpots(val spots: List<Spot>) : HomeViewState()

}