package com.example.intento7.model.repository.localWithRoom

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface SuperHeroesDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertAllSuperHeroes(mList : List<SuperHeroesEntity>)

    @Query("SELECT * FROM super_heroes_table")
    fun showAllSuperHeroes(): LiveData<List<SuperHeroesEntity>>

    @Query("SELECT * FROM SUPER_HEROES_TABLE WHERE id=:mId" )
    fun showOneSuperHeroesById(mId: Int):LiveData<SuperHeroesEntity>
}