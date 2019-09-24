package com.kevicsalazar.uplabs.travelguide.data.network


import com.kevicsalazar.uplabs.travelguide.domain.entities.Category
import com.kevicsalazar.uplabs.travelguide.domain.entities.Spot
import retrofit2.Response
import retrofit2.http.GET

interface Api {

    @GET("api/json/get/Vyowfh1Dv")
    suspend fun getCategories(): Response<List<Category>>

    @GET("api/json/get/EJu4M3kwP")
    suspend fun getSpots(): Response<List<Spot>>

}