package ru.vlabum.simle.rickmorty.data.entity

data class Location(
    val id: Int,
    val name: String,
    val type: String,
    val dimension: String,
    val residents: List<Character>,
    val url: String,
    val created: String
)
