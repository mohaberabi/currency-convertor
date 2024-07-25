package source

import api.CurrencyApi
import dto.toExchangeRate
import model.ExchangeRates
import javax.inject.Inject


class RetrofitCurrencyRemoteDataSource @Inject constructor(
    private val api: CurrencyApi,
) : CurrencyRemoteDataSource {
    override suspend fun getExchangeResponse():
            ExchangeRates = api.getRates().toExchangeRate("")

}