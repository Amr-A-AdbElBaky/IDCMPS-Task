package com.example.idcmps_listing.data.repository

import com.example.core.domain.IdcmpsCacheRepository
import com.example.idcmps_listing.data.model.UniversityResponse
import com.example.idcmps_listing.data.model.mapper.toDao
import com.example.idcmps_listing.data.model.mapper.toEntity
import com.example.idcmps_listing.data.source.ListRemoteDS
import com.example.idcmps_listing.domain.UniversitiesRepository
import com.example.idcmps_listing.domain.entity.UniversityEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.onErrorResumeNext
import javax.inject.Inject

class UniversitiesRepositoryImp @Inject constructor(
    private val remoteDS: ListRemoteDS,
    private val localSource: IdcmpsCacheRepository
) : UniversitiesRepository {
    override fun getUniversitiesList(): Flow<List<UniversityEntity>> {
        return remoteDS.getUniversitiesList()
            .onEach {
                saveUniversities(it)
            }
            .map {
                it.map { item ->
                    item.toEntity()
                }
            }.catch { emit(getLocalUniversities(it)) }
    }

    private suspend fun saveUniversities(it: List<UniversityResponse>) {
        localSource.insertUniversities(
            it.map { it.toDao() })
    }

    private suspend fun getLocalUniversities(error: Throwable): List<UniversityEntity> {
        val list = localSource.getUniversities().map { it.toEntity() }
        if (list.isEmpty())
            throw error
        return list
    }
}