package com.example.intento7.model.repository.localWithRoom

import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "super_heroes_table")
data class SuperHeroesEntity(
    @PrimaryKey(autoGenerate = true) @NonNull val Id: Int,
    val autor: String,
    val fecha: String,
    val version: String,
    val bitcoinNombre: String,
    val dolarNombre: String,
    val dolarIntercambioNombre: String,
    val euroNombre: String,
    val imacecNombre: String,
    val ipcNombre: String,
    val ivpNombre: String,
    val libraCobreNombre: String,
    val tasaDesempleoNombre: String,
    val tpmNombre: String,
    val ufNombre: String,
    val utmNombre: String

//    val height: List<String>,
//    val weight: List<String>,
//    val strength: Int,
//    val slug: String,
//    val base: String,
//    val occupation: String,
)