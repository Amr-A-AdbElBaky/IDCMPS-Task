package com.example.core.data.source

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.core.data.dto.UniversityDto

@Dao
 interface UniversitiesDao {
 
     @Query("SELECT * FROM Universities")
     suspend fun getUniversities(): List<UniversityDto>
 
     @Query("SELECT * FROM Universities WHERE name=:name")
     suspend fun getUniversityByName(name:String):UniversityDto
 
     @Insert(onConflict = OnConflictStrategy.REPLACE)
     suspend fun insertUniversities(universities:List<UniversityDto>)
 
 }