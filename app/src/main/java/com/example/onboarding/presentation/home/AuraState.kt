package com.example.onboarding.presentation.home



sealed interface AuraState {

    data object Idle : AuraState

    data object Listening : AuraState
}