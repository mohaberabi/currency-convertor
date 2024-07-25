package source

import model.ExchangeRates

interface CurrencyRemoteDataSource {
    suspend fun getExchangeResponse(): ExchangeRates
}