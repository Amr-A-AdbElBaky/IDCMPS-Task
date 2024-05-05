package com.example.idcmps_details.domain.interactors

import com.example.idcmps_details.domain.DetailsRepository
import javax.inject.Inject

class GetUniversityDetailsUseCase @Inject constructor(private val repo: DetailsRepository) {
     fun invoke(universityName: String) =
        repo.getUniversityDetails(universityName)
}