package com.example.onboarding.presentation.chat

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.onboarding.presentation.home.ChatState
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withTimeout

class ChatViewModel : ViewModel() {

    private val _state =
        MutableStateFlow<ChatState>(
            ChatState.Idle
        )

    val state: StateFlow<ChatState>
        get() = _state

    private var currentJob: Job? = null

    fun sendMessage(
        message: String
    ) {

        currentJob?.cancel()

        currentJob =
            viewModelScope.launch {

                try {

                    _state.value =
                        ChatState.Typing

                    delay(300)

                    _state.value =
                        ChatState.Validating

                    delay(300)

                    withTimeout(8000) {

                        _state.value =
                            ChatState.Processing

                        delay(2000)

                        _state.value =
                            ChatState.Responding

                        delay(1000)
                    }

                    _state.value =
                        ChatState.Idle

                } catch (e: Exception) {

                    _state.value =
                        ChatState.Error(
                            "Request timed out"
                        )
                }
            }
    }

    fun retry(
        message: String
    ) {

        sendMessage(message)
    }
}