package com.kevicsalazar.uplabs.travelguide.domain.usecases

import com.kevicsalazar.uplabs.travelguide.domain.entities.Category
import com.kevicsalazar.uplabs.travelguide.domain.repository.CategoriesRepository

class GetCategoriesUseCase(private val categoriesRepository: CategoriesRepository) {

    suspend fun getCategories(): List<Category> {
        return categoriesRepository.getCategories()
    }

}