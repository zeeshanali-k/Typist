package tech.devscion.typistdemo

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import tech.devscion.typist.Typist
import tech.devscion.typist.TypistSpeed
import tech.devscion.typistdemo.ui.theme.TypistTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TypistTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Box(contentAlignment = Alignment.Center) {
                        Typist(
                            text = "Hi! I am Typist.",
                            modifier = Modifier
                                .align(Alignment.Center),
                            typistSpeed = TypistSpeed.NORMAL,
                            textStyle = TextStyle(
                                color = Color.Red,
                                fontWeight = FontWeight.Bold,
                                fontSize = 28.sp,
                                textAlign = TextAlign.Center
                            ),
                            isBlinkingCursor = true,
                            isInfiniteCursor = false,
                            isCursorVisible = true,
                            cursorSymbol = "|",
                        ) {
                            Toast.makeText(
                                applicationContext, "Typed!",
                                Toast.LENGTH_LONG
                            )
                                .show()
                        }
                    }
                }
            }
        }
    }
}
