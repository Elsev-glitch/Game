package com.example.game.data.retrofit

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

const val API_KEY = "sd4grh0omdj9a31exnpikhrmsu3v46"

object ApiFactory {
    private val GameInterceptor = Interceptor { chain ->

        val newRequest = chain.request()
            .newBuilder()
            .addHeader("Accept", "application/vnd.twitchtv.v5+json")
            .addHeader("Client-ID", API_KEY)
            .build()

        chain.proceed(newRequest)
    }

    val logging = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)

    private val okHttpClient = OkHttpClient.Builder()
        .addInterceptor(GameInterceptor)
        .addInterceptor(logging)
        .build()

    private fun retrofit(): Retrofit = Retrofit.Builder()
        .client(okHttpClient)
        .baseUrl("https://api.twitch.tv/")
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(CoroutineCallAdapterFactory())
        .build()

    val gameApi: GameApi = retrofit().create(GameApi::class.java)
}