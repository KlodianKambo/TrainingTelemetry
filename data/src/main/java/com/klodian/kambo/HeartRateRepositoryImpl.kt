package com.klodian.kambo
import com.klodian.kambo.domain.repositories.HeartRateRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

internal class HeartRateRepositoryImpl @Inject constructor(private val mockedHeartRateProvider: MockedHeartRateProvider): HeartRateRepository {
    override fun getInstantHrUpdates(): Flow<Int> = mockedHeartRateProvider.provideHeartRateFlow()
}