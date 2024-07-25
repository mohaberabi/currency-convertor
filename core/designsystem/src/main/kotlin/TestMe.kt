import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview


@Composable
fun TestMe(modifier: Modifier = Modifier) {


    Text(text = "ASDASD")
}


@Preview(showBackground = true)
@Composable
private fun TestMePreview() {
    TestMe()
}