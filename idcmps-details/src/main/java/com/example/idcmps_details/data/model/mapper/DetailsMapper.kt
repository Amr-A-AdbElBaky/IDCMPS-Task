package com.example.idcmps_details.data.model.mapper

import com.example.core.data.dto.UniversityDto
import com.example.idcmps_details.domain.entity.UniversityDetailsEntity

fun UniversityDto.toEntity() = UniversityDetailsEntity(
    code = code,
    name = name,
    country = country,
    stateProvince = state,
    webPage = webPage,
    domain = domain
    )