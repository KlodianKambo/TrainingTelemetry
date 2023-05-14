package com.klodian.kambo

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.flow.shareIn
import java.util.Timer
import java.util.TimerTask
import javax.inject.Inject
import javax.inject.Singleton

internal interface MockedHeartRateProvider {
    fun provideHeartRateFlow(): Flow<Int>
}

@Singleton
internal class MockedHeartRateProviderImpl @Inject constructor() : MockedHeartRateProvider {

    private val mockedFlow = callbackFlow {
        // Emit an initial value
        send(0)

        // Emit a new value every 1 second
        val timer = Timer()
        timer.scheduleAtFixedRate(object : TimerTask() {
            override fun run() {
                // Generate a new heart rate value (between 60 and 100)
                val heartRate = (55..180).random()
                trySend(heartRate)
            }
        }, 0, 1000)

        // Cancel the timer and close the flow when the coroutine is cancelled
        awaitClose {
            timer.cancel()
            close()
        }
    }.shareIn(
        CoroutineScope(SupervisorJob() + Dispatchers.IO),
        started = SharingStarted.WhileSubscribed()
    )

    override fun provideHeartRateFlow(): Flow<Int> = mockedFlow
}