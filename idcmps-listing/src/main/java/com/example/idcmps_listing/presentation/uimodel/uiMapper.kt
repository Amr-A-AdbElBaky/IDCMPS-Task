package com.example.idcmps_listing.presentation.uimodel

import com.example.idcmps_listing.domain.entity.UniversityEntity


fun UniversityEntity.toUI() = UniversityUIModel(
    code= code,
    universityName = name,
    universityState = state?:"",
)