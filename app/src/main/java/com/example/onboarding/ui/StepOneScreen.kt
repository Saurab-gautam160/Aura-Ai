package com.example.onboarding.ui

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.onboarding.R
import kotlinx.coroutines.delay

@Composable
fun StepOneScreen() {

    val values = listOf(
        "Private & Secure",
        "Fast AI Responses",
        "Personalized Experience"
    )

    var visibleCount by remember {
        mutableIntStateOf(0)
    }

    LaunchedEffect(Unit) {
        values.indices.forEach { _ ->
            delay(1000)
            visibleCount++
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    colors = listOf(
                        Color(0xFF6C63FF),
                        Color(0xFF4A90E2)
                    )
                )
            )
    ) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp),

            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            Image(
                painter = painterResource(
                    R.drawable.onboarding_ai
                ),
                contentDescription = "AI Illustration",
                modifier = Modifier.size(220.dp)
            )

            Spacer(
                modifier = Modifier.height(20.dp)
            )

            Text(
                text = "Aura AI",
                color = Color.White,
                fontSize = 34.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(
                modifier = Modifier.height(8.dp)
            )

            Text(
                text = "Your Personal Assistant",
                color = Color.White.copy(alpha = 0.9f),
                fontSize = 18.sp
            )

            Spacer(
                modifier = Modifier.height(28.dp)
            )

            values.forEachIndexed { index, item ->

                AnimatedVisibility(
                    visible = index < visibleCount
                ) {

                    ElevatedCard(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 6.dp)
                    ) {

                        Text(
                            text = "✓ $item",
                            fontSize = 16.sp,
                            modifier = Modifier.padding(16.dp)
                        )
                    }
                }
            }
        }
    }
}