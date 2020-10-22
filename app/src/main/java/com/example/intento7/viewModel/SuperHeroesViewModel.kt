package com.example.intento7.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.intento7.modelWithRepository.SuperHeroesRepository
import com.example.intento7.modelWithRepository.roomLocal.SuperHeroesDataBaseClient
import com.example.intento7.modelWithRepository.roomLocal.SuperHeroesEntity

class SuperHeroesViewModel(application: Application): AndroidViewModel(application) {
    private val mRepository: SuperHeroesRepository
    val liveDataFromLocal : LiveData<List<SuperHeroesEntity>>

    init {
        val superHeroesDao = SuperHeroesDataBaseClient.getDatabase(application).superHeroesDao()
        mRepository = SuperHeroesRepository(superHeroesDao)
        mRepository.getDataFromServerWithOutCoroutines()
        liveDataFromLocal = mRepository.allSuperHeroesLiveData
    }
}