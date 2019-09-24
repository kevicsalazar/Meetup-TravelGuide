package com.kevicsalazar.uplabs.travelguide.domain.usecases

import com.kevicsalazar.uplabs.travelguide.domain.entities.Spot
import com.kevicsalazar.uplabs.travelguide.domain.repository.SpotsRepository

class GetSpotsUseCase(private val spotsRepository: SpotsRepository) {

    suspend fun getSpots(): List<Spot> {
        return spotsRepository.getSpots()
    }

}