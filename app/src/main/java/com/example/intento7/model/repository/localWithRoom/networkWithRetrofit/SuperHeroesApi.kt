package com.example.intento7.model.repository.localWithRoom.networkWithRetrofit

import com.example.intento7.model.repository.localWithRoom.networkWithRetrofit.Pojo2.Min
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET

interface SuperHeroesApi {

    //vieja confiable
    @GET("api/")
    fun fetchAllSuperHeroes(): Call<Min>


    //Corroutines
    @GET("api/")
    suspend fun ferchAllSuperHeroesWithCorroutines(): Response<Min>
}

