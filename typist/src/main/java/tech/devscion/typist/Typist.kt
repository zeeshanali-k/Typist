package tech.devscion.typist

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay

@Composable
fun Typist(
    modifier: Modifier = Modifier,
    textStyle: TextStyle = TextStyle(),
    cursorColor: Color = Color.Black,
    typistSpeed: TypistSpeed = TypistSpeed.NORMAL,
    text: String
) {
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
            delay(typistSpeed.value)
        }
    }

    Row(modifier = modifier, horizontalArrangement = Arrangement.Start) {
        Text(
            text = currentText.value,
            style = textStyle,
        )
        Spacer(modifier = Modifier.width(2.dp))
        if (remainingText.value.isNotEmpty())
            Text(text = "|", style = textStyle.copy(color = cursorColor))
    }

}


enum class TypistSpeed(val value: Long) {
    NORMAL(200L), SLOW(500L), EXTRA_SLOW(800L), FAST(100L), EXTRA_FAST(10L)
}
