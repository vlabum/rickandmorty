package ru.vlabum.simle.rickmorty.data.entity

data class Info(
    val count: Int,
    val pages: Int,
    val next: String?,
    val prev: String?
)