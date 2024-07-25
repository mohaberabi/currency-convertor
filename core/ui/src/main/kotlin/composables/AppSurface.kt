package composables


import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import theme.AppTheme
import theme.WhiteBackground

@Composable
fun AppSurface(
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    Surface(
        modifier = modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        val maxWidth = with(LocalDensity.current) {
            LocalConfiguration.current.screenWidthDp.dp.toPx()
        }
        Canvas(
            modifier = Modifier
                .fillMaxWidth()
                .graphicsLayer {
                    translationY = -maxWidth
                    scaleX = 2f
                }
        ) {
            drawCircle(
                brush = Brush.radialGradient(
                    colors = listOf(
                        Color(0x7CC9C9FF),
                        Color(0xFFDDF6F3),
                        WhiteBackground,
                    )
                )
            )
        }
        content()
    }
}

@Preview
@Composable
private fun MCBackgroundScreenPreview() {
    AppTheme {
        AppTheme {

        }
    }
}












