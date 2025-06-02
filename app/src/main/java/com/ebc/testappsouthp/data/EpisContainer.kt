package com.ebc.testappsouthp.data

import com.ebc.testappsouthp.controller.EpisApiService
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import retrofit2.create

interface EpisContainer {
    //puedo tener varias url, varias definiciones del contenedor
    val episRepository: EpisRepository
}

class DefaultEpisContainer: EpisContainer {
    private val BASE_URL = "https://spapi.dev/api/episodes/"

    private val retrofit: Retrofit = Retrofit.Builder()
        .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
        .baseUrl(BASE_URL)
        .build()

        private val retrofitService: EpisApiService by lazy {
        retrofit.create(EpisApiService::class.java)
    }

    override val episRepository: EpisRepository by lazy {
        DefaultEpisContainer(retrofitService)
    }

}