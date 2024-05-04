package com.example.idcmps_listing.core.di

import com.example.idcmps_listing.core.data.RetrofitClient
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
 class RetrofitModule {

    @Provides
    @Singleton
    fun provideClient() = RetrofitClient()
}