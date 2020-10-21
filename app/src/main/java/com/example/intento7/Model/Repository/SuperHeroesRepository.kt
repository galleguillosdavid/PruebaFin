package com.example.intento7.Model.Repository

import android.util.Log
import com.example.intento7.Model.NetworkWithRetrofit.RetrofitClient
import com.example.intento7.Model.NetworkWithRetrofit.SuperHeroes
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SuperHeroesRepository() {
private val retroService = RetrofitClient.getRetrofitClient()

//    La vieja confiable

    fun getDataFromServer() {
        val call = retroService.fetchAllSuperHeroes()
        call.enqueue(object : Callback<List<SuperHeroes>> {
            override fun onResponse(
                call: Call<List<SuperHeroes>>,
                response: Response<List<SuperHeroes>>
            ) {
                when(response.code()){
                    in 200..299 -> Log.d("acierto",response.body().toString())
                    in 300..399 -> Log.d("acierto",response.body().toString())
                    in 400..499 -> Log.d("acierto",response.body().toString())
                    in 500..599 -> Log.d("acierto",response.body().toString())
                    else -> Log.d("acierto",response.body().toString())

                }
                Log.d("error",response.body().toString())
            }

            override fun onFailure(call: Call<List<SuperHeroes>>, t: Throwable) {
                Log.e("error", t.message.toString())
            }
        })
    }
}