package di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import dao.CurrencyDao
import dao.CurrencyLocalDataSource
import dao.RoomCurrencyLocalDataSource
import db.CurrencyDatabase
import model.Currency
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {


    @Singleton
    @Provides
    fun provideAppDatabase(
        @ApplicationContext context: Context,
    ): CurrencyDatabase = Room.databaseBuilder(
        context,
        CurrencyDatabase::class.java,
        CurrencyDatabase.App_DB_NAME
    ).build()


    @Singleton
    @Provides
    fun provideCurrencyLocalDataSource(
        db: CurrencyDatabase,
    ): CurrencyLocalDataSource = RoomCurrencyLocalDataSource(
        dao = db.currencyDao()
    )
}