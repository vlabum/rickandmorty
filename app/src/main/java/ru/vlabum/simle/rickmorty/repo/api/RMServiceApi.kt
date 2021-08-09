package ru.vlabum.simle.rickmorty.repo.api

import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import retrofit2.http.QueryMap
import ru.vlabum.simle.rickmorty.data.entity.CharacterRM
import ru.vlabum.simle.rickmorty.data.entity.CharactersResp

interface RMServiceApi {

    @GET("character")
    fun getAllCharacters(@Query("page") page: Int = 1): Single<CharactersResp>

    @GET("character/{id}")
    fun getCharacter(@Path("id") id: Int): Observable<CharacterRM>

    @GET("character/{ids}")
    fun getMultipleCharacters(@Path("ids") ids: String): Observable<List<CharacterRM>>

    @GET("character")
    fun getFilteredCharacters(
        @QueryMap options: Map<String, String>,
    ): Observable<CharactersResp>

}