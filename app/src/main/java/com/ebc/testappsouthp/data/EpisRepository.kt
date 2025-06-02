package com.ebc.testappsouthp.data

import com.ebc.testappsouthp.controller.EpisApiService
import com.ebc.testappsouthp.models.Epis

interface EpisRepository {
    //aca pondria guardar anfibio o modificar anfinbio si tuviera otro servicio
    //pero solo tendre el GET
    suspend fun getEpisodes(): List<Epis>
}

class DefaultEpisodeRepository(
    private val episApiService: EpisApiService
) : EpisRepository {
    override suspend fun getEpisodes(): List<Epis> {
        return episApiService.getEpisodes()
    }

}