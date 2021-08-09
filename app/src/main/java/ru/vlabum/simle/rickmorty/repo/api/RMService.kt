package ru.vlabum.simle.rickmorty.repo.api

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory


object RMService {

    val client: OkHttpClient
    val retrofit: Retrofit
    val rmService: RMServiceApi

    init {
        val httpLoggingInterceptor = HttpLoggingInterceptor().apply {
            setLevel(HttpLoggingInterceptor.Level.BODY)
        }

        client = OkHttpClient.Builder()
            .addInterceptor(httpLoggingInterceptor)
            .build()

        val moshi = Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()

        retrofit = Retrofit.Builder()
            .client(client)
            .baseUrl(ApiStrings.BASE_URL)
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()

        rmService = retrofit.create(RMServiceApi::class.java)
    }

}