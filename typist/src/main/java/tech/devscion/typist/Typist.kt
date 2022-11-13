package tech.devscion.typist


import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import kotlinx.coroutines.delay


@Composable
fun Typist(modifier: Modifier = Modifier, textStyle: TextStyle = TextStyle(), text: String) {
    val currentText = remember {
        mutableStateOf("")
    }
    val remainingText = remember {
        mutableStateOf(text)
    }

    LaunchedEffect(key1 = true) {
        while (remainingText.value.isNotEmpty()) {
            currentText.value += remainingText.value.first()
            remainingText.value = remainingText.value.removePrefix("${remainingText.value.first()}")
            delay(200)
        }
    }

    Text(
        text = currentText.value,
        modifier = modifier,
        style = textStyle,
    )

}