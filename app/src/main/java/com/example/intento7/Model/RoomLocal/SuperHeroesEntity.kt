package com.example.intento7.Model.RoomLocal

import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "super_heroes_table")
data class SuperHeroesEntity(
    @PrimaryKey
    @NonNull
    val id: Int,
    val imageXs: String,
    val imageLg: String,
    val name: String,
    val alterEgos: String,
    val height: String
)