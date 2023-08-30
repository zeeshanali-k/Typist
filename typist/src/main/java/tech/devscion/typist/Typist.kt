package tech.devscion.typist

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import kotlin.jvm.Throws


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
    isInfinite: Boolean = false,
    cursorSymbol: String = "|",
    onAnimationEnd: (() -> Unit)? = null,
    onAnimationStart: (() -> Unit)? = null,
) {
    TypistImpl(
        listOf(text),
        modifier,
        textStyle,
        cursorColor,
        typistSpeed,
        isInfiniteCursor,
        isBlinkingCursor,
        isCursorVisible,
        isInfinite,
        cursorSymbol,
        onAnimationEnd,
        onAnimationStart,
    )
}

@Throws(InvalidTextListException::class)
@Composable
fun Typist(
    textList: List<String>,
    modifier: Modifier = Modifier,
    textStyle: TextStyle = TextStyle(),
    cursorColor: Color = Color.Black,
    typistSpeed: TypistSpeed = TypistSpeed.NORMAL,
    isInfiniteCursor: Boolean = true,
    isBlinkingCursor: Boolean = true,
    isCursorVisible: Boolean = true,
    isInfinite: Boolean = false,
    cursorSymbol: String = "|",
    onAnimationEnd: (() -> Unit)? = null,
    onAnimationStart: (() -> Unit)? = null,
) {
    if (textList.isEmpty()){
        throw InvalidTextListException()
    }
    TypistImpl(
        textList,
        modifier,
        textStyle,
        cursorColor,
        typistSpeed,
        isInfiniteCursor,
        isBlinkingCursor,
        isCursorVisible,
        isInfinite,
        cursorSymbol,
        onAnimationEnd,
        onAnimationStart,
    )
}