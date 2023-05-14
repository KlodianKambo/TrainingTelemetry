package com.klodian.kambo.trainingtelemetry

import androidx.lifecycle.ViewModel
import com.klodian.kambo.domain.usecases.GetInstantHrStreamUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class HeartRateViewModel @Inject constructor(
    private val getInstantHrStreamUseCase: GetInstantHrStreamUseCase
) : ViewModel() {

    fun getInstantHrUpdates(): Flow<Int> {
        return getInstantHrStreamUseCase()
    }
}