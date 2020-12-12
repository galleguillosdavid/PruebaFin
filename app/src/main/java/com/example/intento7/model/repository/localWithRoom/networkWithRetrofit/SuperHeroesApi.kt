package com.example.intento7.model.repository.localWithRoom.networkWithRetrofit

import com.example.intento7.model.repository.localWithRoom.networkWithRetrofit.pojo3.Gen3Item
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET

interface SuperHeroesApi {

    //vieja confiable
    @GET("products//")
    fun fetchAllSuperHeroes(): Call<Gen3Item>


    //Corroutines
    @GET("products//")
    suspend fun ferchAllSuperHeroesWithCorroutines(): Response<Gen3Item>
}

