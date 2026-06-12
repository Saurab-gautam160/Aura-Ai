package com.example.onboarding.utils

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

object SyncMonitor {

    private val _status =
        MutableStateFlow(
            SyncStatus.IDLE
        )

    val status =
        _status.asStateFlow()

    fun update(
        status: SyncStatus
    ) {

        _status.value =
            status
    }
}