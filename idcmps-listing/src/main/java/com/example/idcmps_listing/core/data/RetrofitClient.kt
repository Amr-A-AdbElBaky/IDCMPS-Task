package com.example.idcmps_listing.core.data
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Singleton
class RetrofitClient {

    private val okHttpBuilder: OkHttpClient.Builder = OkHttpClient.Builder()
    private val retrofit: Retrofit

    init {
        val client = okHttpBuilder.apply {
            addInterceptor(HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BODY })
        }.build()

        val gson = GsonBuilder()
            .setLenient()
            .serializeNulls()
            .create()

        retrofit = Retrofit.Builder()
            .baseUrl(getBaseURL())
            .addConverterFactory(GsonConverterFactory.create(gson))
            .client(client)
            .build()
    }

    private fun getBaseURL(): String {
        return "http://universities.hipolabs.com/"
    }
    fun <S> getService(service: Class<S>): S {
        return retrofit.create(service)
    }


}
