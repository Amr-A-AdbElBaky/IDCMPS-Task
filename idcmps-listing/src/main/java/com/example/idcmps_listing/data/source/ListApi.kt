package com.example.idcmps_listing.data.source
import com.example.idcmps_listing.data.model.UniversityResponse
import retrofit2.http.GET
import retrofit2.http.Url

interface ListApi {
    
    @GET("search?country=United%20Arab%20Emirates")
    suspend fun getUniversitiesList(
    ):List<UniversityResponse>

}