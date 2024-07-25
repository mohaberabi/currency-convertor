package repository

import Syncable
import kotlinx.coroutines.flow.Flow
import model.ExchangeRates

interface CurrencyRepository : Syncable {
    fun getExchangeRates(): Flow<ExchangeRates>
}