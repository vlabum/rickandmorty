package ru.vlabum.simle.rickmorty.repo.data.entity

data class Episode(
    val id: Int,
    val name: String,
    val airDate: String,
    val episode: String,
    val characters: List<CharacterRM>,
    val url: String,
    val created: String
)
