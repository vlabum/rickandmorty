package ru.vlabum.simle.rickmorty.data.api

import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.QueryMap
import ru.vlabum.simle.rickmorty.data.entity.Character
import ru.vlabum.simle.rickmorty.data.entity.ListCharacters

interface RIckAndMortyServiceApi {

    @GET("character")
    fun getAllCharacters(): ListCharacters

    @GET("character/{id}")
    fun getCharacter(@Path("id") id: Int): Character

    @GET("character/{ids}")
    fun getMultipleCharacters(@Path("ids") ids: String): List<Character>

    @GET("character")
    fun getFilteredCharacters(
        @QueryMap options: Map<String, String>,
    ): ListCharacters
}