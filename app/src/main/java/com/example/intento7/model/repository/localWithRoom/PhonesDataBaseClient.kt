package com.example.intento7.model.repository.localWithRoom

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

@Database(entities = [PhonesEntity::class], version = 1)
@TypeConverters(HeightTypeConverter::class)
abstract class PhonesDataBaseClient : RoomDatabase() {
    abstract fun superHeroesDao(): PhonesDao

    companion object {
        @Volatile
        private var INSTANCE: PhonesDataBaseClient? = null
        fun getDatabase(context: Context): PhonesDataBaseClient {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room
                    .databaseBuilder(context, PhonesDataBaseClient::class.java,
                        "superHeroesBd")
                    .build()
                INSTANCE = instance
                return instance
            }
        }
    }
}