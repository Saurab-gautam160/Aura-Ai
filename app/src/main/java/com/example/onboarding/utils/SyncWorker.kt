package com.example.onboarding.utils

import android.content.Context
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import kotlinx.coroutines.delay

class SyncWorker(
    context: Context,
    params: WorkerParameters
) : CoroutineWorker(
    context,
    params
) {

    override suspend fun doWork():
            Result {

        SyncMonitor.update(
            SyncStatus.SYNCING
        )

        delay(2000)

        SyncMonitor.update(
            SyncStatus.SUCCESS
        )

        return Result.success()
    }
}