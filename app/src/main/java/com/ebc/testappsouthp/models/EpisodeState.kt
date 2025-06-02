package com.ebc.testappsouthp.models

import kotlinx.serialization.SerialName

data class EpisodeState (
    val id: Int,
    val name: String,
    val season: Int,
    val episode: Int,
    @SerialName ("thumbnail_url") val imgSrc: String,
    @SerialName ("air_date") val airDate: String,
    @SerialName ("wiki_url") val wikiSrc: String,
    val description: String,
    @SerialName ("created_at") val created: String,
    @SerialName ("updated_a") val updated: String,
    val characters: List<String>,
    val locations: List<String>
)

