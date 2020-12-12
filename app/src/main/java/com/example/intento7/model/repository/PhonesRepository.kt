package com.example.intento7.model.repository

import android.util.Log
import androidx.lifecycle.LiveData
import com.example.intento7.model.repository.localWithRoom.networkWithRetrofit.RetrofitClient

import com.example.intento7.model.repository.localWithRoom.PhonesDao
import com.example.intento7.model.repository.localWithRoom.PhonesEntity
import com.example.intento7.model.repository.localWithRoom.networkWithRetrofit.pojo3.PhonesItem
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PhonesRepository(private val phonesDao: PhonesDao) {

    private val retroService = RetrofitClient.getRetrofitClient()

    // Este muestra toda la tabla de super heroes entity
    val allSuperHeroesLiveData = phonesDao.showAllPhones()

    //Exponer un livedata
    fun getSuperHeroesByid(id: Int): LiveData<PhonesEntity> {
        return phonesDao.showOnePhoneById(id)
    }

    fun deleteAllSuperHeroes() {
        phonesDao.deleteAllPhoneses()
    }

    fun insertOneSuperHero(mPhone: PhonesEntity) {
        phonesDao.insertOnePhone(mPhone)
    }

    //    Corroutines
    fun getDataFromServerWithOutCoroutines() {
        val call = retroService.fetchAllSuperHeroes()
        call.enqueue(object : Callback<PhonesItem> {
            override fun onResponse(
                call: Call<PhonesItem>,
                response: Response<PhonesItem>
            ) {
                when (response.code()) {
                    in 200..299 -> CoroutineScope(Dispatchers.IO).launch {
                        response.body()?.let {
                            phonesDao.insertAllPhones(converters(listOf(it)))
                        }
                    }
                    in 300..399 -> Log.d("acierto", response.body().toString())
                    in 400..499 -> Log.d("acierto", response.body().toString())
                    in 500..599 -> Log.d("acierto", response.body().toString())
                    else -> Log.d("acierto", response.body().toString())
                }
            }

            override fun onFailure(call: Call<PhonesItem>, t: Throwable) {
                Log.e("error", t.message.toString())
            }
        })
    }

    fun converters(listFromNetwork: List<PhonesItem>): List<PhonesEntity> {
        val listMutable = mutableListOf<PhonesEntity>()

        listFromNetwork.map {
            listMutable.add(PhonesEntity(
                            it.id,
                            it.name,
                            it.price,
                            it.image
                    )
            )
        }
        return listMutable
    }
}
