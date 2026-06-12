package com.example.onboarding.presentation.home

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class AudioAmplitudeRecorder {

    private val _amplitude =
        MutableStateFlow(0f)

    val amplitude: StateFlow<Float>
        get() = _amplitude

    fun start() {

        // fake values for now

        _amplitude.value = 0.5f
    }

    fun stop() {

        _amplitude.value = 0f
    }
}