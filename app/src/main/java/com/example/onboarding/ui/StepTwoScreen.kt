package com.example.onboarding.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.onboarding.R
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Lock
@Composable
fun StepTwoScreen(
    name: String,
    age: String,
    phone: String,
    otp: String,
    onNameChange: (String) -> Unit,
    onAgeChange: (String) -> Unit,
    onPhoneChange: (String) -> Unit,
    onOtpChange: (String) -> Unit
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)
            .verticalScroll(
                rememberScrollState()
            ),

        horizontalAlignment =
            Alignment.CenterHorizontally
    ) {

        Image(
            painter = painterResource(
                R.drawable.profile_setup
            ),
            contentDescription = null,
            modifier = Modifier.size(180.dp)
        )

        Spacer(
            modifier = Modifier.height(12.dp)
        )

        Text(
            text = "Create Profile",
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold
        )

        Text(
            text = "Tell us a little about yourself",
            style = MaterialTheme.typography.bodyMedium
        )

        Spacer(
            modifier = Modifier.height(24.dp)
        )

        OutlinedTextField(
            value = name,
            onValueChange = onNameChange,
            label = {
                Text("Full Name")
            },
            leadingIcon = {
                Icon(
                    Icons.Default.Person,
                    contentDescription = null
                )
            },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(
            modifier = Modifier.height(12.dp)
        )

        OutlinedTextField(
            value = age,
            onValueChange = onAgeChange,
            label = {
                Text("Age")
            },
            leadingIcon = {
                Icon(
                    Icons.Default.Face,
                    contentDescription = null
                )
            },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(
            modifier = Modifier.height(12.dp)
        )

        OutlinedTextField(
            value = phone,
            onValueChange = onPhoneChange,
            label = {
                Text("Phone Number")
            },
            leadingIcon = {
                Icon(
                    Icons.Default.Phone,
                    contentDescription = null
                )
            },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(
            modifier = Modifier.height(12.dp)
        )

        OutlinedTextField(
            value = otp,
            onValueChange = onOtpChange,
            label = {
                Text("OTP")
            },
            leadingIcon = {
                Icon(
                    Icons.Default.Lock,
                    contentDescription = null
                )
            },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(
            modifier = Modifier.height(8.dp)
        )

        Text(
            text = "Demo OTP: 1234",
            color = MaterialTheme.colorScheme.primary
        )
    }
}