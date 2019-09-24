package com.kevicsalazar.uplabs.travelguide.domain.entities

import kotlinx.serialization.Serializable

@Serializable
data class Spot(
    val name: String,
    val imageUrl: String = "",
    val imageUrlFull: String = "",
    val type: String = "",
    val about: String = "",
    val shortDescription: String = "",
    val location: String = "",
    val hours: String = "",
    val photos: List<String> = emptyList()
)