package ru.vlabum.simle.rickmorty.data.entity

import ru.vlabum.simle.rickmorty.data.entity.Character
import ru.vlabum.simle.rickmorty.data.entity.Info

data class ListCharacters(
    val info: Info,
    val results: List<Character>
)
