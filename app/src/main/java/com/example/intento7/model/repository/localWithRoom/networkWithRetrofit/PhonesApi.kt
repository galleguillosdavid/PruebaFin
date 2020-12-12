package com.example.intento7.model.repository.localWithRoom.networkWithRetrofit

import com.example.intento7.model.repository.localWithRoom.networkWithRetrofit.pojo3.PhonesItem
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET

interface PhonesApi {

    //vieja confiable
    @GET("products//")
    fun fetchAllSuperHeroes(): Call<PhonesItem>


    //Corroutines
    @GET("products/")
    suspend fun ferchAllSuperHeroesWithCorroutines(): Response<PhonesItem>
}

