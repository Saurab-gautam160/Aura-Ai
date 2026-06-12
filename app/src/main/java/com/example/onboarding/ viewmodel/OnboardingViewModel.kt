
package com.example.onboarding.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.onboarding.model.UserProfile
import com.example.onboarding.datastore.UserPreferences
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class OnboardingViewModel(
    private val preferences: UserPreferences
) : ViewModel() {

    private val _profile =
        MutableStateFlow(UserProfile())

    val profile: StateFlow<UserProfile> =
        _profile.asStateFlow()

    fun updateName(name: String) {
        _profile.value =
            _profile.value.copy(name = name)
    }

    fun updateAge(age: String) {
        _profile.value =
            _profile.value.copy(age = age)
    }

    fun updatePhone(phone: String) {
        _profile.value =
            _profile.value.copy(phone = phone)
    }

    fun updateTraits(traits: List<String>) {
        _profile.value =
            _profile.value.copy(traits = traits)
    }

    fun saveProfile() {

        viewModelScope.launch {

            preferences.saveProfile(
                _profile.value
            )
        }
    }

    fun updateOtp(otp: String) {
        _profile.value = _profile.value.copy(
            otp = otp
        )
    }

    fun validateStep2(): Boolean {

        val profile = _profile.value

        return profile.name.isNotBlank() &&
                profile.age.isNotBlank() &&
                profile.phone.length == 10 &&
                profile.phone.all { it.isDigit() } &&
                profile.otp == "1234"
    }
    fun validateStep3(): Boolean {
        return _profile.value.traits.size == 3
    }
}