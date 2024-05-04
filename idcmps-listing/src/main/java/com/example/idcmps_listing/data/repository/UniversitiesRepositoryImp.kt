package com.example.idcmps_listing.data.repository

import com.example.idcmps_listing.data.model.mapper.toEntity
import com.example.idcmps_listing.data.source.ListRemoteDS
import com.example.idcmps_listing.domain.UniversitiesRepository
import com.example.idcmps_listing.domain.entity.UniversityEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class UniversitiesRepositoryImp @Inject constructor(
    private val remoteDS: ListRemoteDS
) : UniversitiesRepository {
    override fun getUniversitiesList(): Flow<List<UniversityEntity>> {
        return remoteDS.getUniversitiesList()
            .map {
                it.map { item ->
                    item.toEntity()
                }
            }
    }
}