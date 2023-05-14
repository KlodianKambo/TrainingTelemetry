package com.klodian.kambo.trainingtelemetry

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.klodian.kambo.trainingtelemetry.databinding.HeartRateChartFragmentBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch


@AndroidEntryPoint
class HeartRateFragment : Fragment() {

    private var _binding: HeartRateChartFragmentBinding? = null
    private val binding get() = _binding!!

    private val viewModel: HeartRateViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = HeartRateChartFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Observe the heart rate updates and update the chart
        lifecycleScope.launch {
            viewModel.getInstantHrUpdates().collect { heartRate ->
                binding.lineChartView.addValue(heartRate.toFloat())
            }
        }

        lifecycleScope.launch {
            viewModel.fetchCurrentUserInstantEffortPercUpdates().collect {
                binding.instantEffortTextview.text = it?.let { "Instant Effort perc = " + String.format("%.2f", it) + " %" } ?: ""
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
