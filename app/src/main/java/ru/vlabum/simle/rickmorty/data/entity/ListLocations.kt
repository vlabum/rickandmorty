package ru.vlabum.simle.rickmorty.data.entity

import ru.vlabum.simle.rickmorty.data.entity.Info
import ru.vlabum.simle.rickmorty.data.entity.Location

data class ListLocations(
    val info: Info,
    val results: List<Location>
)
