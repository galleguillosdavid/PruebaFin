package com.example.intento7.model.repository.localWithRoom.networkWithRetrofit.pojo3


import com.google.gson.annotations.SerializedName

data class PhonesItem(
    @SerializedName("id")
    val id: Int,
    @SerializedName("image")
    val image: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("price")
    val price: Int
)