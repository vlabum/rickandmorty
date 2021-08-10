package ru.vlabum.simle.rickmorty.repo.data.entity

import com.squareup.moshi.Json

data class CharactersResp(
    @Json(name = "info")    val info: Info,
    @Json(name = "results") val results: List<CharacterRM>
)
