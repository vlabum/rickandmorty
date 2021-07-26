package ru.vlabum.simle.rickmorty.data.api

import io.reactivex.rxjava3.core.Observable
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.QueryMap
import ru.vlabum.simle.rickmorty.data.entity.Character
import ru.vlabum.simle.rickmorty.data.entity.ListCharacters

interface RIckAndMortyServiceApi {

    @GET("character")
    fun getAllCharacters(): Call<ListCharacters>

    @GET("character/{id}")
    fun getCharacter(@Path("id") id: Int): Observable<Character>

    @GET("character/{ids}")
    fun getMultipleCharacters(@Path("ids") ids: String): Call<List<Character>>

    @GET("character")
    fun getFilteredCharacters(
        @QueryMap options: Map<String, String>,
    ): Call<ListCharacters>
}