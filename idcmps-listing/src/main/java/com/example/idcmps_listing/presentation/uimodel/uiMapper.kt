package com.example.idcmps_listing.presentation.uimodel

import com.example.idcmps_listing.domain.entity.UniversityEntity


fun UniversityEntity.toUI() = UniversityUIModel(
    id= id,
    universityName = name,
    universityState = state,
)