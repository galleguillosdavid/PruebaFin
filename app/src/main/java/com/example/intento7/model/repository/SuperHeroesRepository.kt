package com.example.intento7.model.repository

import android.util.Log
import androidx.lifecycle.LiveData
import com.example.intento7.model.repository.networkWithRetrofit.RetrofitClient
import com.example.intento7.model.repository.networkWithRetrofit.SuperHeroes
import com.example.intento7.model.repository.localWithRoom.SuperHeroesDao
import com.example.intento7.model.repository.localWithRoom.SuperHeroesEntity
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

    //Expensder un livedata
    fun getSuperHeroesByid(id: Int): LiveData<SuperHeroesEntity>{
        return superHeroesDao.showOneSuperHeroesById(id)
    }

    //    Corroutines
    fun getDataFromServerWithOutCoroutines() {
        val call = retroService.fetchAllSuperHeroes()
        call.enqueue(object : Callback<List<SuperHeroes>> {
            override fun onResponse(
                call: Call<List<SuperHeroes>>,
                response: Response<List<SuperHeroes>>
            ) {
                when(response.code()){
                    in 200..299 -> CoroutineScope(Dispatchers.IO).launch {
                            response.body()?.let {
                                superHeroesDao.insertAllSuperHeroes(converters(it))
                            }
                        }
                    in 300..399 -> Log.d("acierto",response.body().toString())
                    in 400..499 -> Log.d("acierto",response.body().toString())
                    in 500..599 -> Log.d("acierto",response.body().toString())
                    else -> Log.d("acierto",response.body().toString())
                }
            }
            override fun onFailure(call: Call<List<SuperHeroes>>, t: Throwable) {
                Log.e("error", t.message.toString())
            }
        })
    }

    fun converters(listFromNetwork: List<SuperHeroes>): List<SuperHeroesEntity> {
        val listMutable = mutableListOf<SuperHeroesEntity>()

        listFromNetwork.map {
            listMutable.add(
                SuperHeroesEntity(
                    it.id,
                    it.images.xs,
                    it.images.lg,
                    it.name,
                    it.biography.alterEgos,
                    it.appearance.height,
                    it.appearance.eyeColor,
                        it.biography.aliases
                )
            )
        }
        return listMutable
    }
}