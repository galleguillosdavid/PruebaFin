package com.example.intento7.modelWithRepository.networkWithRetrofit

import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET

interface SuperHeroesApi {

    //vieja confiable
    @GET("all.json")
    fun fetchAllSuperHeroes(): Call<List<SuperHeroes>>


    //Corroutines
    @GET("all.json")
    suspend fun ferchAllSuperHeroesWithCorroutines(): Response<List<SuperHeroes>>
}

