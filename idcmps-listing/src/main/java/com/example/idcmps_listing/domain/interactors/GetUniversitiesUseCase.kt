package com.example.idcmps_listing.domain.interactors

import com.example.idcmps_listing.domain.UniversitiesRepository
import com.example.idcmps_listing.domain.entity.UniversityEntity
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

class GetUniversitiesUseCase @Inject constructor(private val repo: UniversitiesRepository) {
    fun invoke() = repo.getUniversitiesList()
        .onEach {
            repo.saveUniversities(it)
        }.catch { emit(getLocalUniversities(it)) }

    private suspend fun getLocalUniversities(error: Throwable): List<UniversityEntity> {
        val list = repo.getLocalUniversities()
        if (list.isEmpty())
            throw error
        return list
    }
}