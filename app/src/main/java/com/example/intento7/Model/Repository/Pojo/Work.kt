package com.example.intento7.Model.Repository.Pojo


import com.google.gson.annotations.SerializedName

data class Work(
    @SerializedName("base")
    val base: String,
    @SerializedName("occupation")
    val occupation: String
)