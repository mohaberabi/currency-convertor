package worker

import android.content.Context
import androidx.work.WorkInfo
import androidx.work.WorkManager
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject


interface SyncManager {
    val isSyncing: Flow<Boolean>
}


class DefaultSyncManager @Inject constructor(
    @ApplicationContext private val context: Context
) : SyncManager {
    override val isSyncing: Flow<Boolean>
        get() =
            WorkManager.getInstance(context)
                .getWorkInfosForUniqueWorkFlow(WorkerUtil.WORK_NAME)
                .map {
                    it.anyRunning()
                }


}


private fun List<WorkInfo>.anyRunning() = any { it.state == WorkInfo.State.RUNNING }