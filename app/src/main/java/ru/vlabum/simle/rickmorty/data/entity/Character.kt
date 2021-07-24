package ru.vlabum.simle.rickmorty.data.entity

data class Character(
    val id: Int,
    val name: String,
    val status: String,
    val species: String,
    val type: String,
    val gender: String,
    val origin: Location,
    val location: Location,
    val image: String,
    val episode: List<Episode>,
    val url: String,
    val created: String
)