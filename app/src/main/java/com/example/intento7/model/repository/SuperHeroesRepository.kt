package com.example.intento7.model.repository

import android.util.Log
import androidx.lifecycle.LiveData
import com.example.intento7.model.repository.localWithRoom.networkWithRetrofit.RetrofitClient

import com.example.intento7.model.repository.localWithRoom.SuperHeroesDao
import com.example.intento7.model.repository.localWithRoom.SuperHeroesEntity
import com.example.intento7.model.repository.localWithRoom.networkWithRetrofit.Pojo2.Min
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

    //Exponer un livedata
    fun getSuperHeroesByid(id: Int): LiveData<SuperHeroesEntity>{
        return superHeroesDao.showOneSuperHeroesById(id)
    }

    fun deleteAllSuperHeroes(){
        superHeroesDao.deleteAllSuperHeroes()
    }

    fun insertOneSuperHero(mSuperHeroe:SuperHeroesEntity){
        superHeroesDao.insertOneSuperHero(mSuperHeroe)
    }

    //    Corroutines
    fun getDataFromServerWithOutCoroutines() {
        val call = retroService.fetchAllSuperHeroes()
        call.enqueue(object : Callback<Min> {
            override fun onResponse(
                call: Call<Min>,
                response: Response<Min>
            ) {
                when(response.code()){
                    in 200..299 -> CoroutineScope(Dispatchers.IO).launch {
                            response.body()?.let {
                                superHeroesDao.insertAllSuperHeroes(converters(listOf(it)))
                            }
                        }
                    in 300..399 -> Log.d("acierto",response.body().toString())
                    in 400..499 -> Log.d("acierto",response.body().toString())
                    in 500..599 -> Log.d("acierto",response.body().toString())
                    else -> Log.d("acierto",response.body().toString())
                }
            }
            override fun onFailure(call: Call<Min>, t: Throwable) {
                Log.e("error", t.message.toString())
            }
        })
    }

    fun converters(listFromNetwork: List<Min>): List<SuperHeroesEntity> {
        val listMutable = mutableListOf<SuperHeroesEntity>()

        listFromNetwork.map {
            listMutable.add(
                SuperHeroesEntity(
                    Id=55,
                    it.autor,
                        it.fecha,
                        it.version,
                        it.bitcoin.nombre,
                        it.dolar.nombre,
                        it.dolarIntercambio.nombre,
                        it.euro.nombre,
                        it.imacec.nombre,
                        it.ipc.nombre,
                        it.ivp.nombre,
                        it.libraCobre.nombre,
                        it.tasaDesempleo.nombre,
                        it.tpm.nombre,
                        it.uf.nombre,
                        it.utm.nombre,


//                    it.biography.publisher,
//                    it.connections.groupAffiliation,
//                    it.connections.relatives,
//                    it.images.lg,
//                    it.images.md,
//                    it.images.sm,
//                    it.images.xs,
//                    it.name,
//                    it.powerstats.combat,
//                    it.powerstats.durability,
//                    it.powerstats.intelligence,
//                    it.powerstats.power,
//                    it.powerstats.speed,
//                    it.powerstats.strength,
//                    it.slug,
//                    it.work.base,
//                    it.work.occupation
                )
            )
        }
        return listMutable
    }
}