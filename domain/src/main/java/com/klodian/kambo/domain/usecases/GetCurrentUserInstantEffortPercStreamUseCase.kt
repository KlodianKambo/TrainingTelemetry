package com.klodian.kambo.domain.usecases

import com.klodian.kambo.enterprise.usecases.CalculateMaxHRUseCase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

interface GetCurrentUserInstantEffortPercStreamUseCase : suspend () -> Flow<Double?>


class GetCurrentUserInstantEffortPercStreamUseCaseImpl @Inject constructor(
    private val getInstantHrStreamUseCase: GetInstantHrStreamUseCase,
    private val calculateInstantEffortPercUseCase: CalculateInstantEffortPercUseCase,
    private val calculateMaxHRUseCase: CalculateMaxHRUseCase,
    private val getCurrentUserUseCase: GetCurrentUserUseCase
) : GetCurrentUserInstantEffortPercStreamUseCase {

    override suspend fun invoke(): Flow<Double?> {
        val currentUser = getCurrentUserUseCase()
        val maxHr = calculateMaxHRUseCase(currentUser.age, currentUser.gender)
            ?.takeIf { it > 0 } ?: return emptyFlow()

        return getInstantHrStreamUseCase().map { instantHrValue ->
            calculateInstantEffortPercUseCase(instantHrValue, maxHr)
        }
    }
}