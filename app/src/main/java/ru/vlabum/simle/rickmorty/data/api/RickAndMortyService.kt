package ru.vlabum.simle.rickmorty.data.api

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit

@ExperimentalSerializationApi
object RickAndMortyService {

    val client: OkHttpClient
    val retrofit: Retrofit
    val ramService: RIckAndMortyServiceApi

    init {
        val httpLoggingInterceptor = HttpLoggingInterceptor().apply {
            setLevel(HttpLoggingInterceptor.Level.BODY)
        }

        client = OkHttpClient.Builder()
            .addInterceptor(httpLoggingInterceptor)
            .build()

        retrofit = Retrofit.Builder()
            .client(client)
            .baseUrl(ApiStrings.BASE_URL)
            .addConverterFactory(
                Json { ignoreUnknownKeys = true }.asConverterFactory("application/json".toMediaType()))
            .build()

        ramService = retrofit.create(RIckAndMortyServiceApi::class.java)
    }

}