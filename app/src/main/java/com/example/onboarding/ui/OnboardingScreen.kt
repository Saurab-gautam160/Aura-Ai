package com.example.onboarding.ui

import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.onboarding.viewmodel.OnboardingViewModel
import kotlinx.coroutines.launch

@Composable
fun OnboardingScreen(
    viewModel: OnboardingViewModel,
    onFinish: () -> Unit
) {

    val context = LocalContext.current
    val scope = rememberCoroutineScope()

    val pagerState = rememberPagerState(
        pageCount = { 3 }
    )

    val profile by viewModel.profile.collectAsStateWithLifecycle()

    Column(
        modifier = Modifier.fillMaxSize()
    ) {

        HorizontalPager(
            state = pagerState,
            userScrollEnabled = true,
            modifier = Modifier.weight(1f)
        ) { page ->

            when (page) {

                0 -> {
                    StepOneScreen()
                }

                1 -> {
                    StepTwoScreen(
                        name = profile.name,
                        age = profile.age,
                        phone = profile.phone,
                        otp = profile.otp,
                        onNameChange = viewModel::updateName,
                        onAgeChange = viewModel::updateAge,
                        onPhoneChange = viewModel::updatePhone,
                        onOtpChange = viewModel::updateOtp
                    )
                }

                2 -> {
                    StepThreeScreen(
                        selectedTraits = profile.traits,
                        onTraitsChange = viewModel::updateTraits
                    )
                }
            }
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),

            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {

            if (pagerState.currentPage > 0) {

                Button(
                    onClick = {
                        scope.launch {
                            pagerState.animateScrollToPage(
                                pagerState.currentPage - 1
                            )
                        }
                    }
                ) {
                    Text("Back")
                }

            } else {

                Spacer(
                    modifier = Modifier.width(80.dp)
                )
            }

            Button(
                onClick = {

                    when (pagerState.currentPage) {

                        0 -> {

                            scope.launch {
                                pagerState.animateScrollToPage(1)
                            }
                        }

                        1 -> {

                            if (viewModel.validateStep2()) {

                                scope.launch {
                                    pagerState.animateScrollToPage(2)
                                }

                            } else {

                                Toast.makeText(
                                    context,
                                    "Enter valid details and OTP 1234",
                                    Toast.LENGTH_SHORT
                                ).show()
                            }
                        }

                        2 -> {

                            if (viewModel.validateStep3()) {

                                viewModel.saveProfile()

                                onFinish()

                            } else {

                                Toast.makeText(
                                    context,
                                    "Select exactly 3 traits",
                                    Toast.LENGTH_SHORT
                                ).show()
                            }
                        }
                    }
                }
            ) {

                Text(
                    if (pagerState.currentPage == 2)
                        "Get Started"
                    else
                        "Next"
                )
            }
        }
    }

}
