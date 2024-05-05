package com.example.idcmps_listing.data.model.mapper

import com.example.core.data.dto.UniversityDto
import com.example.idcmps_listing.data.model.UniversityResponse
import com.example.idcmps_listing.domain.entity.UniversityEntity

fun UniversityResponse.toEntity() = UniversityEntity(
    id = alphaTwoCode,
    name = name,
    state = country,

    )

fun UniversityResponse.toDao() = UniversityDto(
    code = alphaTwoCode,
    name = name,
    state = stateProvince ?: "",
    country = country,
    webPage = webPages.firstOrNull()?:"",
    domain = domains.firstOrNull()?:""

)

fun UniversityDto.toEntity() = UniversityEntity(
    id = code,
    name = name,
    state = country,

    )