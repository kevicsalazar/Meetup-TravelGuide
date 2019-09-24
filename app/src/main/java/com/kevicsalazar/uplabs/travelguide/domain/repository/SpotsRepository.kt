package com.kevicsalazar.uplabs.travelguide.domain.repository

import com.kevicsalazar.uplabs.travelguide.domain.entities.Spot

interface SpotsRepository {

    suspend fun getSpots(): List<Spot>

}