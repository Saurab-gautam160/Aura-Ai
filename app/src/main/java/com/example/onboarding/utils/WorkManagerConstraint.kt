package com.example.onboarding.utils

import androidx.work.Constraints
import androidx.work.NetworkType

val constraints =
    Constraints.Builder()

        .setRequiredNetworkType(
            NetworkType.CONNECTED
        )

        .build()