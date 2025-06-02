package com.ebc.testappsouthp.controller

import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.Retrofit

object RetrofitInstance {

    private const val BASE_URL = "https://spapi.dev/api/episodes/"

    private fun getInstance(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val episApiService : EpisApiService = getInstance().create(EpisApiService::class.java)

}