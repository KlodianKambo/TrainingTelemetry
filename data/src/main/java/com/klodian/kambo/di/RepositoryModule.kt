package com.klodian.kambo.di

import com.klodian.kambo.HeartRateRepositoryImpl
import com.klodian.kambo.MockedHeartRateProvider
import com.klodian.kambo.MockedHeartRateProviderImpl
import com.klodian.kambo.UserRepositoryImpl
import com.klodian.kambo.domain.repositories.HeartRateRepository
import com.klodian.kambo.domain.repositories.UserRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Provides
    internal fun provideHeartRateRepository(impl: HeartRateRepositoryImpl): HeartRateRepository =
        impl

    @Provides
    fun provideUserRepository(impl: UserRepositoryImpl): UserRepository = impl

    @Provides
    @Singleton
    internal fun provideMockedHeartRateProvider(impl: MockedHeartRateProviderImpl): MockedHeartRateProvider =
        impl

}