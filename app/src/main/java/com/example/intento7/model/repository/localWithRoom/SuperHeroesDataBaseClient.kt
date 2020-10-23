package com.example.intento7.model.repository.localWithRoom

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

@Database(entities = [SuperHeroesEntity::class], version = 1)
@TypeConverters(HeightTypeConverter::class)
abstract class SuperHeroesDataBaseClient : RoomDatabase() {
    abstract fun superHeroesDao(): SuperHeroesDao

    companion object {
        @Volatile
        private var INSTANCE: SuperHeroesDataBaseClient? = null
        fun getDatabase(context: Context): SuperHeroesDataBaseClient {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room
                    .databaseBuilder(context, SuperHeroesDataBaseClient::class.java,
                        "superHeroesBd")
                    .build()
                INSTANCE = instance
                return instance
            }
        }
    }
}