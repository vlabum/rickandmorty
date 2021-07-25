package ru.vlabum.simle.rickmorty.data.entity

import ru.vlabum.simle.rickmorty.data.entity.Episode
import ru.vlabum.simle.rickmorty.data.entity.Info

data class ListEpisodes(
    val info: Info,
    val results: List<Episode>
)
