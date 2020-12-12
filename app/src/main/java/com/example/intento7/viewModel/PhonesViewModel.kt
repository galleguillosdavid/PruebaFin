package com.example.intento7.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.intento7.model.repository.PhonesRepository
import com.example.intento7.model.repository.localWithRoom.PhonesDataBaseClient
import com.example.intento7.model.repository.localWithRoom.PhonesEntity

class PhonesViewModel(application: Application): AndroidViewModel(application) {
    private val mRepository: PhonesRepository
    val liveDataFromLocal : LiveData<List<PhonesEntity>>

    init {
        val superHeroesDao = PhonesDataBaseClient.getDatabase(application).superHeroesDao()
        mRepository = PhonesRepository(superHeroesDao)
        mRepository.getDataFromServerWithOutCoroutines()
        liveDataFromLocal = mRepository.allSuperHeroesLiveData
    }
    fun getSuperHeroesByid(id: Int): LiveData<PhonesEntity>{
        return mRepository.getSuperHeroesByid(id)
    }
    fun deleteAll(){
        mRepository.deleteAllSuperHeroes()
    }
    fun insertOneSuperHeroe(mSoperHeroesEntity: PhonesEntity) {
        mRepository.insertOneSuperHero(mSoperHeroesEntity)
    }
}