package com.kevicsalazar.uplabs.travelguide.domain.repository

import com.kevicsalazar.uplabs.travelguide.domain.entities.Category

interface CategoriesRepository {

    suspend fun getCategories(): List<Category>

}