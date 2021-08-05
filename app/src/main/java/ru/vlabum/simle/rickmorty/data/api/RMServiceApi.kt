package ru.vlabum.simle.rickmorty.data.api

import io.reactivex.rxjava3.core.Observable
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.QueryMap
import ru.vlabum.simle.rickmorty.data.entity.CharacterRM
import ru.vlabum.simle.rickmorty.data.entity.CharactersResp

interface RMServiceApi {

    @GET("character")
    fun getAllCharacters(): Observable<CharactersResp>

    @GET("character/{id}")
    fun getCharacter(@Path("id") id: Int): Observable<CharacterRM>

    @GET("character/{ids}")
    fun getMultipleCharacters(@Path("ids") ids: String): Observable<List<CharacterRM>>

    @GET("character")
    fun getFilteredCharacters(
        @QueryMap options: Map<String, String>,
    ): Observable<CharactersResp>

}