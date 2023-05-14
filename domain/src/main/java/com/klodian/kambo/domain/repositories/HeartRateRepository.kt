package com.klodian.kambo.domain.repositories

import kotlinx.coroutines.flow.Flow

interface HeartRateRepository {
   fun getInstantHrUpdates() : Flow<Int>
}