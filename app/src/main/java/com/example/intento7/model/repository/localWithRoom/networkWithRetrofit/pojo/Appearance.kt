package com.example.intento7.model.repository.localWithRoom.networkWithRetrofit.pojo


import com.google.gson.annotations.SerializedName

data class Appearance(
    @SerializedName("eyeColor")
    val eyeColor: String,
    @SerializedName("gender")
    val gender: String,
    @SerializedName("hairColor")
    val hairColor: String,
    @SerializedName("height")
    val height: List<String>,
    @SerializedName("race")
    val race: String="Sin especificar",
    @SerializedName("weight")
    val weight: List<String>
)