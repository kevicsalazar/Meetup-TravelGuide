package com.kevicsalazar.uplabs.travelguide.data.repository

import com.kevicsalazar.uplabs.travelguide.data.network.Api
import com.kevicsalazar.uplabs.travelguide.data.network.utils.safeApiCall
import com.kevicsalazar.uplabs.travelguide.domain.entities.Category
import com.kevicsalazar.uplabs.travelguide.domain.repository.CategoriesRepository

class CategoriesDataRepository(private val api: Api) : CategoriesRepository {

    override suspend fun getCategories(): List<Category> {
        return safeApiCall { api.getCategories() } ?: emptyList()
    }
}