package presentation.screen

import AppTextMenu
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue

import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.mohaberabi.feature.convertor.R
import composables.AppCard
import composables.AppSurface
import composables.AppTextField
import kotlinx.coroutines.launch
import presentation.viewmodel.ConvertorActions
import presentation.viewmodel.ConvertorState
import presentation.viewmodel.ConvertorViewModel
import presentation.viewmodel.CurrencyUiModel
import theme.AppTheme


@Composable
fun CurrencyConvertorRoot(
    viewModel: ConvertorViewModel = hiltViewModel()
) {
    val state by viewModel.state.collectAsStateWithLifecycle()

    CurrencyConvertorScreen(
        state = state,
        onAction = viewModel::onAction
    )
}

@Composable
internal fun CurrencyConvertorScreen(
    state: ConvertorState,
    onAction: (ConvertorActions) -> Unit,
) {
    AppSurface {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .statusBarsPadding()
        ) {
            Spacer(modifier = Modifier.height(30.dp))
            Text(
                text = stringResource(id = R.string.currency_convertor),
                style = MaterialTheme.typography.headlineLarge,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(10.dp))

            Text(
                text = stringResource(id = R.string.currency_convertor_description),
                modifier = Modifier.padding(horizontal = 16.dp),
                textAlign = TextAlign.Center,
                color = Color(0xff808080),
                fontSize = 16.sp
            )

            Spacer(modifier = Modifier.height(50.dp))

            CurrencyConvertorCard(
                allCurrencies = state.currencies.keys.toList(),
                fromCurrency = state.fromCurrency,
                toCurrency = state.toCurrency,
                fromValueChanged = { onAction(ConvertorActions.FromValueChanged(it)) },
                toValueChanged = { },
                fromCodeChanged = { onAction(ConvertorActions.FromCodeChanged(it)) },
                toCodeChanged = { onAction(ConvertorActions.ToCodeChanged(it)) },
                onSwap = { onAction(ConvertorActions.SwapCurrency) }
            )

            Spacer(modifier = Modifier.height(30.dp))

            Text(
                text = "${stringResource(id = R.string.indicative_exhange_rate)} ${state.lastTime}",
                modifier = Modifier.padding(horizontal = 22.dp),
                style = MaterialTheme.typography.labelSmall
            )


            if (state.loading) {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    CircularProgressIndicator(
                        modifier = Modifier
                            .size(30.dp)
                            .testTag("loading")
                    )
                }
            }
        }

    }
}

@Composable
private fun CurrencyConvertorCard(
    modifier: Modifier = Modifier,
    allCurrencies: List<String>,
    fromCurrency: CurrencyUiModel,
    toCurrency: CurrencyUiModel,
    fromValueChanged: (String) -> Unit,
    toValueChanged: (String) -> Unit,
    fromCodeChanged: (String) -> Unit,
    toCodeChanged: (String) -> Unit,
    onSwap: () -> Unit
) {
    AppCard(
        modifier = modifier
            .padding(horizontal = 16.dp)
            .fillMaxWidth()
    ) {
        CurrencyInfoRow(
            label = stringResource(id = R.string.amount),
            value = fromCurrency.value,
            currencies = allCurrencies,
            onValueChanged = fromValueChanged,
            onCodeChanged = fromCodeChanged,
            code = fromCurrency.code
        )


        Spacer(modifier = Modifier.height(20.dp))

        CurrenciesSwapper(
            onSwap = onSwap
        )

        Spacer(modifier = Modifier.height(10.dp))

        CurrencyInfoRow(
            label = stringResource(id = R.string.converted_amount),
            currencies = allCurrencies,
            onValueChanged = toValueChanged,
            onCodeChanged = toCodeChanged,
            code = toCurrency.code,
            value = toCurrency.value
        )
    }
}

@Composable
private fun CurrencyInfoRow(
    modifier: Modifier = Modifier,
    label: String,
    currencies: List<String>,
    onCodeChanged: (String) -> Unit,
    onValueChanged: (String) -> Unit,
    code: String,
    value: String,
) {


    Column(
        modifier = modifier
    ) {
        Text(text = label, style = MaterialTheme.typography.labelSmall)

        Spacer(modifier = Modifier.height(15.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            AnimatedContent(
                targetState = code,
                modifier = Modifier.weight(1f), label = "",
            ) {
                AppTextMenu(
                    selectedOption = it,
                    options = currencies,
                    onOptionSelected = { i ->
                        onCodeChanged(currencies[i])
                    }
                )
            }

            Spacer(modifier = Modifier.height(30.dp))

            AppTextField(
                value = value,
                onValueChange = onValueChanged,
                modifier = Modifier.weight(1f),
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Number
                )
            )
        }
    }
}

@Composable
fun CurrenciesSwapper(
    modifier: Modifier = Modifier,
    onSwap: () -> Unit
) {

    val animatable = remember {
        androidx.compose.animation.core.Animatable(0f)
    }

    val scope = rememberCoroutineScope()

    Box(modifier = modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
        HorizontalDivider()
        Box(
            modifier = Modifier
                .size(44.dp)
                .clip(CircleShape)
                .background(MaterialTheme.colorScheme.primary)
                .clickable {
                    if (animatable.isRunning)
                        return@clickable

                    scope.launch {
                        onSwap()
                        animatable.animateTo(
                            animatable.value + 180f,
                            tween(300)
                        )
                    }
                }
                .testTag("swap"),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                painter = painterResource(id = R.drawable.exchange),
                contentDescription = null,
                tint = Color.White,
                modifier = Modifier
                    .padding(10.dp)
                    .rotate(animatable.value)
            )
        }
    }
}


@Preview
@Composable
private fun PreviewConvertorScreen() {
    AppTheme {
        CurrencyConvertorScreen(
            state = ConvertorState.PreviewData,
            onAction = {},
        )


    }
}
