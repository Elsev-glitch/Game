package com.example.game.data.retrofit

import com.example.game.data.entity.ResponseGame
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.GET

interface GameApi {
    @GET("kraken/games/top")
    fun getPopularGame(): Deferred<Response<ResponseGame>>
}