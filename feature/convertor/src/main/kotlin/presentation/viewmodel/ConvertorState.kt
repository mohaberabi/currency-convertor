package presentation.viewmodel

import presentation.util.CurrencyConvertor


data class ConvertorState(


    val loading: Boolean = false,
    val currencies: Map<String, Double> = mapOf(),
    val fromCode: String = "",
    val fromValue: String = "1.0",
    val toCode: String = "",
    val lastTime: String = "",
) {


    companion object {
        val PreviewData = ConvertorState(
            fromCode = "USD",
            fromValue = "1000.00",
            toCode = "USD",
        )
    }

    private val exchanged: String
        get() =
            CurrencyConvertor.convert(
                fromCurrencyRateVsBaseCurrencyRate = currencies[fromCode] ?: 1.0,
                toCurrencyRateVsBaseCurrencyRate = currencies[toCode] ?: 1.0,
                amount = fromValue.toDoubleOrNull() ?: 1.0
            ).let {
                String.format(java.util.Locale.getDefault(), "%.2f", it)
            }
    val fromCurrency
        get() = CurrencyUiModel(
            code = fromCode, value = fromValue,
        )
    val toCurrency
        get() = CurrencyUiModel(
            code = toCode, value = exchanged,
        )


}

