package model

data class Currency(
    val code: String,
    val value: Double
)


data class ExchangeRates(
    val baseCurrency: String = "",
    val rates: Map<String, Double>,
    val lastUpdatedDate: String
)

data class CurrencyMeta(
    val lastUpdatedDate: String,
)

