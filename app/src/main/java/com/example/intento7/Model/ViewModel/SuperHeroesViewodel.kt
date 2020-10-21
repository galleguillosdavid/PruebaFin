package com.example.intento7.Model.ViewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.intento7.Model.Repository.SuperHeroesRepository
import com.example.intento7.Model.RoomLocal.SuperHeroesDataBase
import com.example.intento7.Model.RoomLocal.SuperHeroesEntity

class SuperHeroesViewodel(application: Application): AndroidViewModel(application) {
    private val mRepository: SuperHeroesRepository
    val liveDataFromLocal : LiveData<List<SuperHeroesEntity>>

    init {
        val superHeroesDao = SuperHeroesDataBase.getDatabase(application).superHeroesDao()
        mRepository = SuperHeroesRepository(superHeroesDao)
        mRepository.getDataFromServer()
        liveDataFromLocal = mRepository.allSuperHeroesLiveData
    }
}