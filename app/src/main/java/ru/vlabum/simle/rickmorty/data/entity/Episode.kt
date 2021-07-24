package ru.vlabum.simle.rickmorty.data.entity

data class Episode(
    val id: Int,
    val name: String,
    val airDate: String,
    val episode: String,
    val characters: List<Character>,
    val url: String,
    val created: String
)