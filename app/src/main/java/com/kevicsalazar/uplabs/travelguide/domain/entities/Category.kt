package com.kevicsalazar.uplabs.travelguide.domain.entities

import kotlinx.serialization.Serializable

@Serializable
data class Category(
    val name: String = "",
    val imageUrl: String = ""
)