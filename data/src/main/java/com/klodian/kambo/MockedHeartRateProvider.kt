package com.klodian.kambo

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.shareIn
import javax.inject.Inject
import javax.inject.Singleton

internal interface MockedHeartRateProvider {
    fun provideHeartRateFlow(): Flow<Int>
}

@Singleton
internal class MockedHeartRateProviderImpl @Inject constructor() : MockedHeartRateProvider {
    private val mockedFlow = flow {
        emit(0)
        while (true) {
            // Generate a new heart rate value (between 60 and 100)
            val heartRate = (55..188).random()
            // Emit the new value
            emit(heartRate)
            // Wait for 1 second
            delay(1000)
        }
    }.shareIn(
        CoroutineScope(SupervisorJob() + Dispatchers.IO),
        started = SharingStarted.WhileSubscribed()
    )

    override fun provideHeartRateFlow(): Flow<Int> = mockedFlow
}