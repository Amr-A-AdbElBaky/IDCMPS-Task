package com.example.core.data.source

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.core.data.dto.UniversityDto

@Database(entities = [UniversityDto::class], version = 1)
 abstract class IDCMPSDataBase : RoomDatabase() {
 
     abstract fun getUniversitiesDao(): UniversitiesDao
 
 }