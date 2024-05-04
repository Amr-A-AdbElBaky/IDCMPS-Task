package com.example.idcmps_listing.domain

import com.example.idcmps_listing.domain.entity.UniversityEntity
import kotlinx.coroutines.flow.Flow

interface UniversitiesRepository {
     fun getUniversitiesList():Flow<List<UniversityEntity>>
}