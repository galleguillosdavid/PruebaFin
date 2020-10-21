package com.example.intento7.Model.NetworkWithRetrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClient {
    companion object {
private const val URL_BASE = "https://akabab.github.io/superhero-api/api"

        fun getRetrofitClient(): SuperHeroesApi {
            val mRetrofit = Retrofit.Builder()
                .baseUrl(URL_BASE)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        return mRetrofit.create(SuperHeroesApi::class.java)
        }

    }
}