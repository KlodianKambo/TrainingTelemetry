package com.klodian.kambo.domain.usecases

import javax.inject.Inject

interface CalculateInstantEffortPercUseCase : (Int, Int) -> Double?

class CalculateInstantEffortPercUseCaseImpl @Inject constructor() : CalculateInstantEffortPercUseCase {
   override fun invoke(instantHr: Int, maxHr: Int): Double? {
       if(instantHr < 1 || maxHr < 1) return null
       return instantHr.toDouble() / maxHr.toDouble()
   }
}