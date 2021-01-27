package com.example.game.data.entity


import com.google.gson.annotations.SerializedName

data class ResponseGame(
    @SerializedName("top")
    val top: List<Top>
)