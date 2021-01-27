package com.example.article.data.repository

import com.example.game.data.entity.Top
import com.example.game.data.retrofit.GameApi

class GameRepository(private val api: GameApi) : BaseRepository() {
    suspend fun getPosts(): MutableList<Top>? {
        val postResponse = safeApiCall(
            call = { api.getPopularGame().await() },
            errorMesage = "Error Post"
        )
        return postResponse?.top?.toMutableList()
    }
}