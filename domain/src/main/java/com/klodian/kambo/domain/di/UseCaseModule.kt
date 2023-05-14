package com.klodian.kambo.domain.di

import com.klodian.kambo.domain.usecases.CalculateInstantEffortPercUseCase
import com.klodian.kambo.domain.usecases.CalculateInstantEffortPercUseCaseImpl
import com.klodian.kambo.domain.usecases.GetCurrentUserUseCase
import com.klodian.kambo.domain.usecases.GetCurrentUserUseCaseImpl
import com.klodian.kambo.domain.usecases.GetInstantHrStreamUseCase
import com.klodian.kambo.domain.usecases.GetInstantHrStreamUseCaseImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class UseCaseModule {
    @Provides
    fun provideCalculateInstantEffortPercUseCase(impl: CalculateInstantEffortPercUseCaseImpl): CalculateInstantEffortPercUseCase = impl

    @Provides
    fun provideGetCurrentUserUseCase(impl: GetCurrentUserUseCaseImpl): GetCurrentUserUseCase = impl

    @Provides
    fun provideGetInstantHrStreamUseCase(impl: GetInstantHrStreamUseCaseImpl): GetInstantHrStreamUseCase = impl
}