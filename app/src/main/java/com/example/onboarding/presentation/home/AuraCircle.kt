package com.example.onboarding.presentation.home

import androidx.compose.animation.core.*
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun AuraCircle(
    state: AuraState,
    chatState: ChatState, // <-- 1. Add this parameter!
    amplitude: Float,
    modifier: Modifier = Modifier
) {

    Text(
        text = when(state) {
            AuraState.Idle -> "Idle"
            AuraState.Listening -> "Listening..."
        }
    )

    // Now this will compile perfectly
    Text(
        text = when (chatState) {
            ChatState.Idle -> "Idle"
            ChatState.Typing -> "Typing..."
            ChatState.Validating -> "Validating..."
            ChatState.Processing -> "Processing..."
            ChatState.Responding -> "Responding..."
            is ChatState.Error -> "Error"
        },
        style = MaterialTheme.typography.titleMedium
    )

    Spacer(modifier = Modifier.height(16.dp))

    val transition = rememberInfiniteTransition(label = "Aura")

    val scale by transition.animateFloat(
        initialValue = 0.9f,
        targetValue = 1.1f,
        animationSpec = infiniteRepeatable(
            animation = tween(2000),
            repeatMode = RepeatMode.Reverse
        ),
        label = "Scale"
    )

    val radius = when (state) {
        AuraState.Idle -> 120f * scale
        AuraState.Listening -> 120f + amplitude * 200f
    }

    Canvas(modifier = modifier.size(300.dp)) {
        drawCircle(
            color = Color(0xFF6C63FF),
            radius = radius,
            center = Offset(size.width / 2, size.height / 2)
        )

        drawCircle(
            color = Color(0x556C63FF),
            radius = radius + 30f,
            center = Offset(size.width / 2, size.height / 2)
        )
    }
}