package dao

import entity.toEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import model.Currency
import model.ExchangeRates
import util.toIso
import java.time.Instant
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import javax.inject.Inject


class RoomCurrencyLocalDataSource @Inject constructor(
    private val dao: CurrencyDao,
) : CurrencyLocalDataSource {
    override suspend fun addAllCurrencies(currencies: List<Currency>, lastTime: String) {
        dao.upsertAll(currencies.map { it.toEntity(lastTime) })
    }

    override fun getAllCurrencies(): Flow<ExchangeRates> {
        return dao.getAllCurrencies().map { list ->
            val rates = list.associate { it.code to it.value }
            val lastTime = list.firstOrNull()?.lastTime ?: LocalDateTime.now().toIso()
            ExchangeRates(
                rates = rates,
                lastUpdatedDate = lastTime
            )
        }

    }


}