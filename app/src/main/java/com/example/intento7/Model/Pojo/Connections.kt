package com.example.intento7.Model.Pojo


import com.google.gson.annotations.SerializedName

data class Connections(
    @SerializedName("groupAffiliation")
    val groupAffiliation: String,
    @SerializedName("relatives")
    val relatives: String
)