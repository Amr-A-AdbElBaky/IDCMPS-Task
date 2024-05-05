package com.example.core.data.repository

import com.example.core.data.dto.UniversityDto
import com.example.core.data.source.IDCMPSDataBase
import com.example.core.data.source.UniversitiesDao
import com.example.core.domain.IdcmpsCacheRepository
import javax.inject.Inject

class IdcmpsRepositoryImpl @Inject constructor(private val dB: IDCMPSDataBase)
    : IdcmpsCacheRepository{
    override suspend fun getUniversities(): List<UniversityDto> {
        return dB.getUniversitiesDao().getUniversities()
    }

    override suspend fun getUniversityByName(name: String): UniversityDto {
        return dB.getUniversitiesDao().getUniversityByName(name)
    }

    override suspend fun insertUniversities(universities: List<UniversityDto>) {
        return dB.getUniversitiesDao().insertUniversities(universities)
    }

}