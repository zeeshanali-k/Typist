package tech.devscion.typist

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay

@Composable
fun Typist(
    text: String,
    modifier: Modifier = Modifier,
    textStyle: TextStyle = TextStyle(),
    cursorColor: Color = Color.Black,
    typistSpeed: TypistSpeed = TypistSpeed.NORMAL,
    isInfiniteCursor: Boolean = true,
    isBlinkingCursor: Boolean = true,
    isCursorVisible: Boolean = true,
    cursorSymbol: String = "|",
    onAnimationEnd: (() -> Unit)? = null
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
        if (remainingText.value.isEmpty()) {
            onAnimationEnd?.invoke()
        }
    }

    Row(
        modifier = modifier
            .animateContentSize()
            .padding(end = 5.dp),
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = currentText.value,
            style = textStyle,
        )
        Spacer(modifier = Modifier.width(2.dp))
        if (isCursorVisible) {
            val isCursorActive = remainingText.value.isNotEmpty() || isInfiniteCursor
            if (isBlinkingCursor && isCursorActive)
                BlinkingCursor(
                    style = textStyle.copy(color = cursorColor),
                    typistSpeed = typistSpeed,
                    cursorSymbol = cursorSymbol
                )
            else if (isCursorActive)
                Text(
                    text = cursorSymbol,
                    style = textStyle.copy(color = cursorColor),
                )
        }
    }

}


enum class TypistSpeed(val value: Long) {
    NORMAL(200L), SLOW(500L), EXTRA_SLOW(800L), FAST(100L), EXTRA_FAST(10L)
}
