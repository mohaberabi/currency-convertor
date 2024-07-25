package worker

import android.content.Context
import androidx.hilt.work.HiltWorker
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import dagger.assisted.Assisted
import dagger.assisted.AssistedInject
import repository.CurrencyRepository
import DefaultSyncer


@HiltWorker
class SyncWorker @AssistedInject constructor(
    @Assisted private val context: Context,
    @Assisted params: WorkerParameters,
    private val currencyRepository: CurrencyRepository,
) : CoroutineWorker(context, params) {


    override suspend fun doWork(): Result {
        return try {
            currencyRepository.syncWith(DefaultSyncer())
            Result.success()
        } catch (e: Exception) {
            Result.failure()
        }
    }
}