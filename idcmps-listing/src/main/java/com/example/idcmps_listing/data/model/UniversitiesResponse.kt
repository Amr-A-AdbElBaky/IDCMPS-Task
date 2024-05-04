package com.example.idcmps_listing.data.model

import com.google.gson.annotations.SerializedName


data class UniversityResponse(
    @SerializedName("alpha_two_code")
    val alphaTwoCode:String,
    val name: String,
    val country: String,
    val domains: List<String>,
    @SerializedName("web_pages")
    val webPages: List<String>,
    @SerializedName("state_province")
    val stateProvince: String?
)
