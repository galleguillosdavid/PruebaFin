package com.example.intento7.Model.Repository

import android.util.Log
import com.example.intento7.Model.NetworkWithRetrofit.RetrofitClient
import com.example.intento7.Model.NetworkWithRetrofit.SuperHeroes
import com.example.intento7.Model.RoomLocal.SuperHeroesDao
import com.example.intento7.Model.RoomLocal.SuperHeroesEntity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SuperHeroesRepository(private val superHeroesDao: SuperHeroesDao) {

    private val retroService = RetrofitClient.getRetrofitClient()
    // Este muestra toda la tabla de super heroes entity
    val allSuperHeroesLiveData = superHeroesDao.showAllSuperHeroes()
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
                    CoroutineScope(Dispatchers.IO).launch {
                        response.body()?.let {
                            superHeroesDao.insertAllSuperHeroes(convert(it))
                        }
                    }
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

    fun convert(listFromNetwork: List<SuperHeroes>): List<SuperHeroesEntity> {
        val listMutable = mutableListOf<SuperHeroesEntity>()
        listFromNetwork.map {
            listMutable.add(
                SuperHeroesEntity(
                    it.id,
                    it.images.xs,
                    it.images.lg,
                    it.name,
                    it.biography.alterEgos,
                    it.appearance.height
                )
            )
        }
        return listMutable
    }
}