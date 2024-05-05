package com.example.idcmps_details.domain.entity

data class UniversityDetailsEntity(
    val code:String ="",
    val name: String ="",
    val country: String ="",
    val domain: String = "",
    val webPage: String = "",
    val stateProvince: String? =""
)