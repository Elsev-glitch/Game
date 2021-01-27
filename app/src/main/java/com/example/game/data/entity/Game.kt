package com.example.game.data.entity


import com.google.gson.annotations.SerializedName

data class Game(
    @SerializedName("box")
    val box: Box,
    @SerializedName("_id")
    val id: Int,
    @SerializedName("name")
    val name: String
)