package com.example.onboarding.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.onboarding.R

@Composable
fun StepThreeScreen(
    selectedTraits: List<String>,
    onTraitsChange: (List<String>) -> Unit
) {

    val traits = listOf(
        "Creative",
        "Focused",
        "Funny",
        "Calm",
        "Leader",
        "Analytical",
        "Friendly",
        "Adventurous"
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),

        horizontalAlignment =
            Alignment.CenterHorizontally
    ) {

        Image(
            painter = painterResource(
                R.drawable.personality
            ),
            contentDescription = null,
            modifier = Modifier.size(180.dp)
        )

        Spacer(
            modifier = Modifier.height(12.dp)
        )

        Text(
            text = "Choose Your Personality",
            fontSize = 26.sp,
            fontWeight = FontWeight.Bold
        )

        Text(
            text = "Select exactly 3 traits",
            style = MaterialTheme.typography.bodyMedium
        )

        Spacer(
            modifier = Modifier.height(12.dp)
        )

        Card {

            Text(
                text =
                    "${selectedTraits.size}/3 Selected",

                modifier =
                    Modifier.padding(12.dp)
            )
        }

        Spacer(
            modifier = Modifier.height(20.dp)
        )

        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            verticalArrangement =
                Arrangement.spacedBy(10.dp),

            horizontalArrangement =
                Arrangement.spacedBy(10.dp)
        ) {

            items(traits) { trait ->

                FilterChip(

                    selected =
                        selectedTraits.contains(
                            trait
                        ),

                    onClick = {

                        val updated =
                            selectedTraits.toMutableList()

                        if (
                            updated.contains(
                                trait
                            )
                        ) {

                            updated.remove(
                                trait
                            )

                        } else if (
                            updated.size < 3
                        ) {

                            updated.add(
                                trait
                            )
                        }

                        onTraitsChange(
                            updated
                        )
                    },

                    label = {
                        Text(trait)
                    },

                    colors =
                        FilterChipDefaults
                            .filterChipColors(

                                selectedContainerColor =
                                    Color(
                                        0xFF6C63FF
                                    ),

                                selectedLabelColor =
                                    Color.White
                            )
                )
            }
        }
    }
}