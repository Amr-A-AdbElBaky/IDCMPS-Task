package com.example.core.di

import android.content.Context
import androidx.room.Room
import com.example.core.data.repository.IdcmpsRepositoryImpl
import com.example.core.data.source.IDCMPSDataBase
import com.example.core.data.source.UniversitiesDao
import com.example.core.domain.IdcmpsCacheRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class IDCMPSDataBaseModule {

    @Singleton
    @Provides
    fun provideDatabase(
        @ApplicationContext context: Context,
    ): IDCMPSDataBase {
        return Room.databaseBuilder(context, IDCMPSDataBase::class.java, "Universities.db")
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    fun provideChannelDao(appDatabase: IDCMPSDataBase): UniversitiesDao {
        return appDatabase.getUniversitiesDao()
    }

}

@Module
@InstallIn(SingletonComponent::class)
abstract class IdcmpsCacheRepositoryModule {

    @Binds
    abstract fun bindIdcmpsCacheRepository(repo: IdcmpsRepositoryImpl): IdcmpsCacheRepository
}
