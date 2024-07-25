import kotlinx.coroutines.supervisorScope

interface Syncable {
    suspend fun syncWith(syncer: DefaultSyncer)
}

class DefaultSyncer {

    suspend fun <T> start(
        fetchRemote: suspend () -> T,
        deleteLocal: (suspend () -> Unit)? = null,
        updateLocal: suspend (T) -> Unit,
    ) {
        supervisorScope {
            val remote = fetchRemote()
            val deleted = deleteLocal?.invoke()
            updateLocal(remote)
        }

    }
}