package com.mohaberabi.kurrencykonvertor

import android.app.Application
import android.content.Context
import androidx.work.Configuration
import androidx.work.ExistingWorkPolicy
import androidx.work.ListenableWorker
import androidx.work.WorkManager
import androidx.work.WorkerFactory
import androidx.work.WorkerParameters
import dagger.hilt.android.HiltAndroidApp
import repository.CurrencyRepository
import worker.SyncWorker
import worker.WorkerUtil
import worker.WorkerUtil.WORK_NAME
import worker.WorkerUtil.defaultWorkRequest
import javax.inject.Inject

@HiltAndroidApp
class KonvertorApp : Application(), Configuration.Provider {


    @Inject
    lateinit var workerFactory: AppHiltWorkerFactory
    override fun onCreate() {
        super.onCreate()

        enqueueDefaultWorker()
    }


    private fun enqueueDefaultWorker() {
        WorkManager.getInstance(this).beginUniqueWork(
            WORK_NAME,
            ExistingWorkPolicy.KEEP,
            defaultWorkRequest
        ).enqueue()
    }

    override val workManagerConfiguration: Configuration
        get() = Configuration.Builder()
            .setWorkerFactory(workerFactory)
            .build()
}

class AppHiltWorkerFactory @Inject constructor(
    private val currencyRepository: CurrencyRepository,
) : WorkerFactory() {
    override fun createWorker(
        appContext: Context,
        workerClassName: String,
        workerParameters: WorkerParameters
    ): ListenableWorker {
        return SyncWorker(
            currencyRepository = currencyRepository,
            context = appContext,
            params = workerParameters
        )
    }

}