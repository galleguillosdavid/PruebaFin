package com.example.intento7.model.repository.localWithRoom.networkWithRetrofit.pojo


import com.google.gson.annotations.SerializedName

data class Work(
    @SerializedName("base")
    val base: String,
    @SerializedName("occupation")
    val occupation: String
)