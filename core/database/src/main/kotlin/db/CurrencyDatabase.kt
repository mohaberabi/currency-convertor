package db

import androidx.room.Database
import androidx.room.RoomDatabase
import dao.CurrencyDao
import entity.CurrencyEntity

@Database(
    entities = [CurrencyEntity::class],
    version = 1,
)
abstract class CurrencyDatabase : RoomDatabase() {

    companion object {
        const val App_DB_NAME = "currency.db"
    }

    abstract fun currencyDao(): CurrencyDao
}