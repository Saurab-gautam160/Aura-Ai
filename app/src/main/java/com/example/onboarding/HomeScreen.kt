package com.example.onboarding.presentation.home

import android.annotation.SuppressLint
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Keyboard
import androidx.compose.material.icons.filled.Mic
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.unit.dp
import com.example.onboarding.presentation.chat.ChatViewModel

@SuppressLint("FrequentlyChangingValue")
@Composable
fun HomeScreen(
    viewModel: HomeViewModel
) {
    var showInput by remember { mutableStateOf(false) }
    val chatViewModel = remember { ChatViewModel() }
    val chatState by chatViewModel.state.collectAsState()
    var message by remember { mutableStateOf("") }

    val scrollState = rememberScrollState()
    val progress = (scrollState.value / 600f).coerceIn(0f, 1f)

    val state by viewModel.auraState.collectAsState()
    val amplitude by viewModel.amplitude.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(scrollState),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(80.dp))

        AuraCircle(
            state = state,
            chatState = chatState,
            amplitude = amplitude,
            modifier = Modifier.graphicsLayer {
                alpha = 1f - progress
                translationY = -200f * progress
            }
        )

        Spacer(modifier = Modifier.height(32.dp))

        Row {
            FloatingActionButton(
                onClick = {
                    if (state == AuraState.Listening) {
                        viewModel.stopListening()
                    } else {
                        viewModel.startListening()
                    }
                }
            ) {
                Icon(Icons.Default.Mic, contentDescription = "Mic")
            }

            Spacer(modifier = Modifier.width(16.dp))

            FloatingActionButton(
                onClick = { showInput = !showInput }
            ) {
                Icon(Icons.Default.Keyboard, contentDescription = "Keyboard")
            }
        }

        AnimatedVisibility(
            visible = showInput,
            enter = slideInVertically { it },
            exit = slideOutVertically { it }
        ) {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Row(
                    modifier = Modifier.padding(12.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    OutlinedTextField(
                        value = message,
                        onValueChange = { message = it },
                        modifier = Modifier.weight(1f),
                        label = { Text("Type a message") }
                    )

                    Spacer(modifier = Modifier.width(8.dp))

                    Button(
                        onClick = {
                            if (message.isNotBlank()) {
                                message = ""
                            }
                        }
                    ) {
                        Text("Send")
                    }
                }
            }
        }

        Spacer(modifier = Modifier.height(400.dp))

        repeat(20) { index ->
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 6.dp)
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text(text = "User")
                    Text(text = "Message ${index + 1}")
                }
            }
        }

        Spacer(modifier = Modifier.height(40.dp))
    }
}