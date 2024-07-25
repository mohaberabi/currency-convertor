package presentation.viewmodel

sealed interface ConvertorActions {


    data class FromValueChanged(val value: String) : ConvertorActions
    data class FromCodeChanged(val value: String) : ConvertorActions
    data class ToCodeChanged(val value: String) : ConvertorActions
    data object SwapCurrency : ConvertorActions

}