package com.klodian.kambo.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.klodian.kambo.domain.usecases.GetCurrentUserInstantEffortPercStreamUseCase
import com.klodian.kambo.domain.usecases.GetInstantHrStreamUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.shareIn
import javax.inject.Inject

@HiltViewModel
class HeartRateViewModel @Inject constructor(
    private val getInstantHrStreamUseCase: GetInstantHrStreamUseCase,
    private val getCurrentUserInstantEffortPercStreamUseCase: GetCurrentUserInstantEffortPercStreamUseCase
) : ViewModel() {

    fun getInstantHrUpdates(): Flow<Int> = getInstantHrStreamUseCase()

    suspend fun fetchCurrentUserInstantEffortPercUpdates() = getCurrentUserInstantEffortPercStreamUseCase()

}