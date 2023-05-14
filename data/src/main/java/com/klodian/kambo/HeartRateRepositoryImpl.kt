package com.klodian.kambo
import com.klodian.kambo.domain.repositories.HeartRateRepository
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class HeartRateRepositoryImpl @Inject constructor(): HeartRateRepository {
    override fun getInstantHrUpdates(): Flow<Int> = flow {
        // Emit an initial value
        emit(0)

        // Emit a new value every 1 second
        while (true) {
            // Generate a new heart rate value (between 60 and 100)
            val heartRate = (55..180).random()
            emit(heartRate)

            // Wait for 1 second
            delay(1000)
        }
    }
}