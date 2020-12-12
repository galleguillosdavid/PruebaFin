package com.example.intento7.model.repository.localWithRoom

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface PhonesDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
     fun insertOnePhone(mSuperHeroe:PhonesEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
     fun insertAllPhones(mList : List<PhonesEntity>)


    @Update
     fun updateOnePhone(mSuperHeroe: PhonesEntity)

    @Update
     fun updateAllPhones(mList: List<PhonesEntity>)


    @Query("SELECT * FROM super_heroes_table")
     fun showAllPhones(): LiveData<List<PhonesEntity>>

    @Query("SELECT * FROM super_heroes_table WHERE id=:mId" )
     fun showOnePhoneById(mId: Int):LiveData<PhonesEntity>


    @Delete
    fun deleteOnePhone(mSuperHeroe: PhonesEntity)

    @Query("DELETE  FROM super_heroes_table")
    fun  deleteAllPhoneses()


}