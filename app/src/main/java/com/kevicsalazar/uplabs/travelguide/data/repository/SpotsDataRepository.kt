package com.kevicsalazar.uplabs.travelguide.data.repository

import com.kevicsalazar.uplabs.travelguide.data.network.Api
import com.kevicsalazar.uplabs.travelguide.data.network.utils.safeApiCall
import com.kevicsalazar.uplabs.travelguide.domain.entities.Spot
import com.kevicsalazar.uplabs.travelguide.domain.repository.SpotsRepository

class SpotsDataRepository(private val api: Api) : SpotsRepository {

    override suspend fun getSpots(): List<Spot> {
        return safeApiCall { api.getSpots() } ?: emptyList()
    }

}