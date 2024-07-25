package di

import DefaultSyncer
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import repository.CurrencyRepository
import repository.OfflineFirstCurrencyRepository
import source.CurrencyRemoteDataSource
import source.RetrofitCurrencyRemoteDataSource
import worker.DefaultSyncManager
import worker.SyncManager


@InstallIn(SingletonComponent::class)
@Module
abstract class CoreDataModule {


    @Binds
    abstract fun bindCurrencyRemoteDataSource(
        impl: RetrofitCurrencyRemoteDataSource,
    ): CurrencyRemoteDataSource

    @Binds
    abstract fun bindCurrencyRepository(
        impl: OfflineFirstCurrencyRepository,
    ): CurrencyRepository

    @Binds
    abstract fun bindsyncManager(
        impl: DefaultSyncManager,
    ): SyncManager
}




