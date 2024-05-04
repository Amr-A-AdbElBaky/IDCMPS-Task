package com.example.idcmps_listing.data.model.mapper

import com.example.idcmps_listing.data.model.UniversityResponse
import com.example.idcmps_listing.domain.entity.UniversityEntity

fun UniversityResponse.toEntity() = UniversityEntity(
    id = alphaTwoCode,
    name = name,
    state = country,

)