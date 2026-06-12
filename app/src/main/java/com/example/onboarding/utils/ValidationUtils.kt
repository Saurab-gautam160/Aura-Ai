package com.example.onboarding.utils

object ValidationUtils {

    fun validateStep2(
        name: String,
        age: String,
        phone: String,
        otp: String
    ): Boolean {

        return name.isNotBlank() &&
                age.isNotBlank() &&
                phone.length == 10 &&
                phone.all { it.isDigit() } &&
                otp == "1234"
    }
}