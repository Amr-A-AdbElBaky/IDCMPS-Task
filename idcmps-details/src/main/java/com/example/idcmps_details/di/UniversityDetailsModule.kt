package com.example.idcmps_details.di

import com.example.idcmps_details.data.DetailsRepositoryImp
import com.example.idcmps_details.domain.DetailsRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class UniversityDetailsModule {

    @Binds
    abstract fun bindDetailsRepository(repo: DetailsRepositoryImp): DetailsRepository
}