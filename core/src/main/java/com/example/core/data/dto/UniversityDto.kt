package com.example.core.data.dto

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Universities")
 data class UniversityDto(
     @PrimaryKey
     val name: String,
     val code: String,
     val country: String,
     val webPage: String,
     val domain:  String,
     val state: String
 
 )