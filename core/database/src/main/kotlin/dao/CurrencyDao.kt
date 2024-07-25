package dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import entity.CurrencyEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface CurrencyDao {


    @Upsert
    suspend fun upsertAll(currencies: List<CurrencyEntity>)


    @Query("SELECT * FROM currency")
    fun getAllCurrencies(): Flow<List<CurrencyEntity>>
}