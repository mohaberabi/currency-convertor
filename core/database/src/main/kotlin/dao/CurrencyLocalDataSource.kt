package dao

import kotlinx.coroutines.flow.Flow
import model.Currency
import model.ExchangeRates

interface CurrencyLocalDataSource {


    suspend fun addAllCurrencies(
        currencies: List<Currency>,
        lastTime: String
    )

    fun getAllCurrencies(): Flow<ExchangeRates>
}