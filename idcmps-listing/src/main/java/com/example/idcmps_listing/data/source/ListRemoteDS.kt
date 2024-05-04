package com.example.idcmps_listing.data.source

import com.example.idcmps_listing.core.data.RetrofitClient
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
import javax.inject.Singleton


class ListRemoteDS @Inject constructor(
    retrofitClient: RetrofitClient,
) {

    private val listApi = retrofitClient.getService(ListApi::class.java)
    fun getUniversitiesList() = flow {
        val response =
            listApi.getUniversitiesList()
        emit(response)
    }


    companion object {
        private const val UNIVERSITIES_URL =
            "http://universities.hipolabs.com"

    }
}
