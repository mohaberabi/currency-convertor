package repository

import dao.CurrencyLocalDataSource
import kotlinx.coroutines.flow.Flow
import model.Currency
import model.ExchangeRates
import source.CurrencyRemoteDataSource
import DefaultSyncer
import util.formatAsDateTime
import javax.inject.Inject

class OfflineFirstCurrencyRepository @Inject constructor(
    private val currencyRemoteDataSource: CurrencyRemoteDataSource,
    private val currencyLocalDatasource: CurrencyLocalDataSource,
) : CurrencyRepository {

    override fun getExchangeRates(): Flow<ExchangeRates> =
        currencyLocalDatasource.getAllCurrencies()


    override suspend fun syncWith(syncer: DefaultSyncer) {
        syncer.start(
            fetchRemote = { currencyRemoteDataSource.getExchangeResponse() },
            updateLocal = { curr ->
                currencyLocalDatasource.addAllCurrencies(
                    curr.rates.map {
                        Currency(
                            code = it.key,
                            value = it.value
                        )
                    }.toList(),
                    lastTime = curr.lastUpdatedDate.formatAsDateTime()
                )
            }
        )
    }


}