package com.klodian.kambo.enterprise.usecases

import com.klodian.kambo.enterprise.entities.UserGender
import javax.inject.Inject
import kotlin.math.roundToInt

interface CalculateMaxHRUseCase : (Int, UserGender) -> Int?

class CalculateMaxHRUseCaseImpl @Inject constructor() : CalculateMaxHRUseCase {
   override fun invoke(age : Int, biologicalGender: UserGender): Int? {
       if(age < 0) return null
       return when(biologicalGender){
           UserGender.M -> 214 - (0.8 * age)
           UserGender.F -> 209 - (0.7 * age)
       }.roundToInt()
   }
}