package worker

import android.content.Context
import androidx.work.Constraints
import androidx.work.ExistingWorkPolicy
import androidx.work.NetworkType
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager

object WorkerUtil {

    const val WORK_NAME = "syncWork"
    val defaultConstraints =
        Constraints.Builder()
            .setRequiredNetworkType(NetworkType.CONNECTED)
            .build()


    val defaultWorkRequest =
        OneTimeWorkRequestBuilder<SyncWorker>()
            .setConstraints(constraints = defaultConstraints)
            .build()


}