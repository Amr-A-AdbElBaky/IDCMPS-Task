package com.example.idcmps_listing.data.model.mapper

import com.example.core.data.dto.UniversityDto
import com.example.idcmps_listing.data.model.UniversityResponse
import com.example.idcmps_listing.domain.entity.UniversityEntity

fun UniversityResponse.toEntity() = UniversityEntity(
    code = alphaTwoCode,
    name = name,
    state = stateProvince ?: "",
    country = country,
    webPage = webPages.firstOrNull()?:"",
    domain = domains.firstOrNull()?:""


)

fun UniversityEntity.toDao() = UniversityDto(
    code = code,
    name = name,
    state = state ?: "",
    country = country,
    webPage = webPage,
    domain = domain

)

fun UniversityDto.toEntity() = UniversityEntity(
    code = code,
    name = name,
    state = state,
    country = country,
    webPage = webPage,
    domain = domain


    )