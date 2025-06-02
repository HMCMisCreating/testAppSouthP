package com.ebc.testappsouthp.controller

import com.ebc.testappsouthp.models.Epis
import retrofit2.Response
import retrofit2.http.GET

interface EpisApiService {

    @GET("epis")
    suspend fun getEpisodes(): Response<List<Epis>>
}