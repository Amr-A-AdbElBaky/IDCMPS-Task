package com.example.idcmps_details.domain

import com.example.idcmps_details.domain.entity.UniversityDetailsEntity
import kotlinx.coroutines.flow.Flow

interface DetailsRepository {
     fun getUniversityDetails(universityName: String): Flow<UniversityDetailsEntity>
}