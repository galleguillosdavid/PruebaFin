package com.example.intento7.model.repository.localWithRoom

import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "super_heroes_table")
data class PhonesEntity(
    @PrimaryKey @NonNull
    val Id: Int,
    val Name: String,
    val Price: Int,
    val Image: String
)