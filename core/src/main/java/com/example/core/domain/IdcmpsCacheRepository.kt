package com.example.core.domain

import com.example.core.data.dto.UniversityDto


interface IdcmpsCacheRepository {

    suspend fun getUniversities(): List<UniversityDto>

    suspend fun getUniversityByName(name:String): UniversityDto

    suspend fun insertUniversities(universities:List<UniversityDto>)
}