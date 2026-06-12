package com.example.onboarding.presentation.home


sealed class ChatState {

    data object Idle : ChatState()

    data object Typing : ChatState()

    data object Validating : ChatState()

    data object Processing : ChatState()

    data object Responding : ChatState()

    data class Error(
        val message: String
    ) : ChatState()
}