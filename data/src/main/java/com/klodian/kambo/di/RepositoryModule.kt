package com.klodian.kambo.di

import com.klodian.kambo.HeartRateRepositoryImpl
import com.klodian.kambo.domain.repositories.HeartRateRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Provides
    fun provideHeartRateRepository(impl: HeartRateRepositoryImpl): HeartRateRepository = impl

}