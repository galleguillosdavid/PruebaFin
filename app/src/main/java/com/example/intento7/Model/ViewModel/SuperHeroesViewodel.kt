package com.example.intento7.Model.ViewModel

import androidx.lifecycle.ViewModel
import com.example.intento7.Model.Repository.SuperHeroesRepository

class SuperHeroesViewodel: ViewModel() {
    private val mRepository: SuperHeroesRepository

    init {
        mRepository = SuperHeroesRepository()
    }
}