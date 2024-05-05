package com.example.idcmps_listing.domain.entity

data class UniversityEntity(
    val code:String ="",
    val name: String ="",
    val country: String ="",
    val domain: String = "",
    val webPage: String = "",
    val state: String? =""
)