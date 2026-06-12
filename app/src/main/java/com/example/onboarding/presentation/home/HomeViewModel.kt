package com.example.onboarding.presentation.home

import android.app.Application // <-- 1. Add this import
import androidx.lifecycle.AndroidViewModel // <-- 2. Change import from ViewModel to AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.onboarding.data.local.entity.DatabaseProvider
import com.example.onboarding.data.local.entity.repo.ChatRepository
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

// 3. Accept application in constructor and pass it to AndroidViewModel
class HomeViewModel(application: Application) : AndroidViewModel(application) {

    private val recorder = AudioAmplitudeRecorder()

    // 4. 'application' is now perfectly valid here!
    private val repository = ChatRepository(
        DatabaseProvider.getDatabase(application).chatDao()
    )

    private var listeningJob: Job? = null

    private val _auraState = MutableStateFlow<AuraState>(AuraState.Idle)
    val auraState = _auraState.asStateFlow()

    val amplitude = recorder.amplitude

    fun startListening() {
        if (_auraState.value == AuraState.Listening) return

        _auraState.value = AuraState.Listening
        listeningJob = viewModelScope.launch {
            recorder.start()
        }
    }

    fun stopListening() {
        recorder.stop()
        listeningJob?.cancel()
        _auraState.value = AuraState.Idle
    }
}