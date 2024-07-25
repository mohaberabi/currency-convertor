package dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import model.Currency
import model.CurrencyMeta
import model.ExchangeRates


@Serializable
data class ExchangeResponseDto(
    val data: Map<String, CurrencyDto>,
    val meta: CurrencyMetaDto,
)


@Serializable
data class CurrencyDto(
    val code: String,
    val value: Double,
)


@Serializable
data class CurrencyMetaDto(
    @SerialName("last_updated_at")
    val lastUpdatedAt: String,
)

fun ExchangeResponseDto.toExchangeRate(
    base: String,
): ExchangeRates = ExchangeRates(
    rates = data.mapValues { it.value.value },
    baseCurrency = base,
    lastUpdatedDate = meta.lastUpdatedAt
)


fun CurrencyMetaDto.toMeta() = CurrencyMeta(lastUpdatedDate = lastUpdatedAt)
fun CurrencyDto.toCurrency(): Currency = Currency(code = code, value = value)

