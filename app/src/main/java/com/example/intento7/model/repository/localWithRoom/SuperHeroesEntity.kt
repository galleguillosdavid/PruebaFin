package com.example.intento7.model.repository.localWithRoom

import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "super_heroes_table")
data class SuperHeroesEntity(
    @PrimaryKey @NonNull val id: Int,
    val eyeColor: String,
    val gender: String,
    val hairColor: String,
    val race: String?="",
    val height: List<String>,
    val weight: List<String>,
    val alignment: String,
    val alterEgos: String,
    val firstAppearance: String,
    val fullName: String,
    val placeOfBirth: String,
    val publisher: String?="",
    val groupAffiliation: String,
    val relatives: String,
    val lg: String,
    val md: String,
    val sm: String,
    val xs: String,
    val name: String,
    val combat: Int,
    val durability: Int,
    val intelligence: Int,
    val power: Int,
    val speed: Int,
    val strength: Int,
    val slug: String,
    val base: String,
    val occupation: String,
)