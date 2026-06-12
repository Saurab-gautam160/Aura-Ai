package com.example.onboarding.model

data class UserProfile(
    val name: String = "",
    val age: String = "",
    val phone: String = "",
    val otp: String = "",
    val traits: List<String> = emptyList()
)