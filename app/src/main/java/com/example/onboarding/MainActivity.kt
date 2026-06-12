package com.example.onboarding

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.onboarding.datastore.UserPreferences
import com.example.onboarding.presentation.home.HomeScreen
import com.example.onboarding.presentation.home.HomeViewModel
import com.example.onboarding.ui.OnboardingScreen
import com.example.onboarding.viewmodel.OnboardingViewModel

class MainActivity : ComponentActivity() {

    private lateinit var onboardingViewModel: OnboardingViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Initialize DataStore helper
        val userPreferences = UserPreferences(applicationContext)

        // Initialize ViewModel
        onboardingViewModel = OnboardingViewModel(userPreferences)

        setContent {
            var showHome by remember {
                mutableStateOf(false)
            }

            if (showHome) {
                // 2. Use the viewModel() delegate instead of remember { HomeViewModel() }
                val homeViewModel: HomeViewModel = viewModel()

                HomeScreen(
                    viewModel = homeViewModel
                )

            } else {

                OnboardingScreen(
                    viewModel = onboardingViewModel,
                    onFinish = {
                        showHome = true
                    }
                )
            }
        }
    }
}