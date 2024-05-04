package com.example.idcmps_listing.domain.interactors

import com.example.idcmps_listing.domain.UniversitiesRepository
import javax.inject.Inject

class GetUniversitiesUseCase @Inject constructor(private val repo: UniversitiesRepository) {
    fun invoke() = repo.getUniversitiesList()
}