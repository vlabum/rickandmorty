package ru.vlabum.simle.rickmorty.data.entity

import com.squareup.moshi.Json
import ru.vlabum.simle.rickmorty.data.entity.Character
import ru.vlabum.simle.rickmorty.data.entity.Info

data class ListCharacters(
    @Json(name = "info")
    val info: Info,
    @Json(name = "results")
    val results: List<Character>
)
