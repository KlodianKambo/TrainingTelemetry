package com.klodian.kambo.domain.usecases

import com.klodian.kambo.domain.repositories.HeartRateRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

interface GetInstantHrStreamUseCase : () -> Flow<Int>

class GetInstantHrStreamUseCaseImpl @Inject constructor(private val heartRateRepository: HeartRateRepository) :
    GetInstantHrStreamUseCase {
    override fun invoke(): Flow<Int> = heartRateRepository.getInstantHrUpdates()
}