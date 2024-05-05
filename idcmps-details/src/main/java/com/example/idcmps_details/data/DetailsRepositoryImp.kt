package com.example.idcmps_details.data

import com.example.core.data.source.UniversitiesDao
import com.example.idcmps_details.data.model.mapper.toEntity
import com.example.idcmps_details.domain.DetailsRepository
import com.example.idcmps_details.domain.entity.UniversityDetailsEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class DetailsRepositoryImp @Inject constructor(private val detailsDao: UniversitiesDao)
    :DetailsRepository{
    override fun getUniversityDetails(universityName: String): Flow<UniversityDetailsEntity>{
        return  flow {
            emit(detailsDao.getUniversityByName(universityName)
                .toEntity())
        }
    }
}