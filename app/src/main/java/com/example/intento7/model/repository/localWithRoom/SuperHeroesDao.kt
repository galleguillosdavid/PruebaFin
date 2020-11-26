package com.example.intento7.model.repository.localWithRoom

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface SuperHeroesDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
     fun insertOneSuperHero(mSuperHeroe:SuperHeroesEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
     fun insertAllSuperHeroes(mList : List<SuperHeroesEntity>)


    @Update
     fun updateOneSuperHero(mSuperHeroe: SuperHeroesEntity)

    @Update
     fun updateAllSuperHeroes(mList: List<SuperHeroesEntity>)


    @Query("SELECT * FROM super_heroes_table")
     fun showAllSuperHeroes(): LiveData<List<SuperHeroesEntity>>

    @Query("SELECT * FROM super_heroes_table WHERE id=:mId" )
     fun showOneSuperHeroesById(mId: Int):LiveData<SuperHeroesEntity>

//    @Query("SELECT * FROM super_heroes_table WHERE eyeColor=:mEyeColor" )
//     fun showAllSuperHeroesByYellowEyeColor(mEyeColor: String):LiveData<List<SuperHeroesEntity>>




    @Delete
    fun deleteOneSuperHeroe(mSuperHeroe: SuperHeroesEntity)

    @Query("DELETE  FROM super_heroes_table")
    fun  deleteAllSuperHeroes()

    @Delete
    fun delleteAllYellowEyeColor(mList: List<SuperHeroesEntity>)

}