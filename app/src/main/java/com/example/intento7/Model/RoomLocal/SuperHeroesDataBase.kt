package com.example.intento7.Model.RoomLocal

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [SuperHeroesEntity::class], version = 1)
abstract class SuperHeroesDataBase : RoomDatabase() {
    abstract fun superHeroesDao(): SuperHeroesDao

    companion object {
        @Volatile
        var INSTANCE: SuperHeroesDataBase? = null
        fun getDatabase(context: Context): SuperHeroesDataBase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room
                    .databaseBuilder(context, SuperHeroesDataBase::class.java,
                        "superHeroesBd")
                    .build()
                INSTANCE = instance
                return instance
            }
        }
    }
}