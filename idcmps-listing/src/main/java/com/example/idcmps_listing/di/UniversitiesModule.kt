package com.example.idcmps_listing.di

import com.example.idcmps_listing.data.repository.UniversitiesRepositoryImp
import com.example.idcmps_listing.domain.UniversitiesRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class UniversitiesModule {

    @Binds
    abstract fun bindAddVitalSignsRemote(repo: UniversitiesRepositoryImp): UniversitiesRepository
}