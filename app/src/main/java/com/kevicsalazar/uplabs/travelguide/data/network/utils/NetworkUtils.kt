package com.kevicsalazar.uplabs.travelguide.data.network.utils

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import com.kevicsalazar.uplabs.travelguide.BuildConfig
import kotlinx.serialization.json.Json
import okhttp3.MediaType
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.HttpException
import retrofit2.Response
import retrofit2.Retrofit
import java.util.concurrent.TimeUnit


const val CONTENT_TYPE_JSON = "application/json"

fun createRetrofit(httpClient: OkHttpClient, baseUrl: String): Retrofit {
    val contentType = MediaType.get(CONTENT_TYPE_JSON)
    return Retrofit.Builder()
        .baseUrl(baseUrl)
        .addConverterFactory(Json.asConverterFactory(contentType))
        .client(httpClient)
        .build()
}

fun createOkHttpClient(f: (Request.Builder.() -> Request.Builder)? = null): OkHttpClient {
    return OkHttpClient.Builder()
        .addInterceptor { chain ->
            val original = chain.request()
            val requestBuilder = original.newBuilder()
            val request = (f?.invoke(requestBuilder) ?: requestBuilder)
            chain.proceed(request.build())
        }
        .addNetworkInterceptor(HttpLoggingInterceptor().apply {
            level = if (BuildConfig.DEBUG) {
                HttpLoggingInterceptor.Level.BODY
            } else {
                HttpLoggingInterceptor.Level.NONE
            }
        })
        .readTimeout(3, TimeUnit.MINUTES)
        .connectTimeout(5, TimeUnit.MINUTES)
        .build()
}

suspend fun <T : Any> safeApiCall(call: suspend () -> Response<T>): T? {
    val response = call.invoke()
    if (response.isSuccessful) {
        return response.body()
    } else {
        throw HttpException(response)
    }
}
