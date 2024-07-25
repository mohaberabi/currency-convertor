package presentation.viewmodel

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import repository.CurrencyRepository
import worker.SyncManager
import javax.inject.Inject

@HiltViewModel
class ConvertorViewModel @Inject constructor(
    private val currencyRepository: CurrencyRepository,
    private val savedStateHandle: SavedStateHandle,
    syncManager: SyncManager,
) : ViewModel() {

    companion object {
        private const val FROM_KEY = "fromKey"
        private const val TO_KEY = "toKey"

    }

    private val fromValue = savedStateHandle[FROM_KEY] ?: ""
    private val toValue = savedStateHandle[TO_KEY] ?: ""

    private val _state = MutableStateFlow(
        ConvertorState(
            fromCode = fromValue,
            toCode = toValue
        )
    )

    val state = _state.asStateFlow()

    init {
        syncManager.isSyncing.onEach { loading ->
            _state.update { it.copy(loading = loading) }
        }.launchIn(viewModelScope)


        currencyRepository.getExchangeRates().onEach { res ->
            _state.update {
                it.copy(
                    currencies = res.rates,
                    fromCode = res.rates.keys.firstOrNull() ?: "",
                    toCode = res.rates.keys.firstOrNull() ?: "",
                    lastTime = res.lastUpdatedDate
                )
            }
        }.launchIn(viewModelScope)
    }

    fun onAction(action: ConvertorActions) {
        when (action) {
            is ConvertorActions.FromCodeChanged -> {
                _state.update { it.copy(fromCode = action.value) }
                savedStateHandle[FROM_KEY] = action.value
            }

            is ConvertorActions.FromValueChanged -> _state.update { it.copy(fromValue = action.value) }
            is ConvertorActions.ToCodeChanged -> {
                _state.update { it.copy(toCode = action.value) }
                savedStateHandle[TO_KEY] = action.value
            }

            ConvertorActions.SwapCurrency -> {
                val stateVal = _state.value
                val temp = stateVal.toCode
                _state.update { it.copy(toCode = stateVal.fromCode, fromCode = temp) }
            }
        }
    }


}