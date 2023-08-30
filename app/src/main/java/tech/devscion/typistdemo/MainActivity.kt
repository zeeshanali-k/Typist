package tech.devscion.typistdemo

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
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
                    color = MaterialTheme.colorScheme.background
                ) {
                    Column(verticalArrangement = Arrangement.Center,
                        modifier = Modifier.fillMaxSize()) {
                        Typist(
                            text = "Hi! I am Typist.",
                            typistSpeed = TypistSpeed.FAST,
                            textStyle = TextStyle(
                                color = Color.Red,
                                fontWeight = FontWeight.Bold,
                                fontSize = 28.sp,
                                textAlign = TextAlign.Center
                            ),
                            isBlinkingCursor = true,
                            isInfiniteCursor = false,
                            isCursorVisible = true,
                            onAnimationEnd = {
                                Toast.makeText(
                                    applicationContext, "Typed!",
                                    Toast.LENGTH_LONG
                                )
                                    .show()
                            }
                        )
                        Spacer(modifier = Modifier.height(15.dp))
                        Typist(
                            text = "Hi! I am Typist.",
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
                            isInfinite = true
                        )
                        Spacer(modifier = Modifier.height(15.dp))
                        Typist(
                            textList = listOf("Hi! I am Typist.","And I can type multiple times"),
                            typistSpeed = TypistSpeed.NORMAL,
                            textStyle = TextStyle(
                                color = Color.Red,
                                fontWeight = FontWeight.Bold,
                                fontSize = 28.sp,
                                textAlign = TextAlign.Center
                            ),
                            isInfinite = true,
                            isBlinkingCursor = false,
                            isInfiniteCursor = true,
                            isCursorVisible = true,
                        )
                        Spacer(modifier = Modifier.height(15.dp))
                        Typist(
                            textList = listOf("Hi! I am Typist.","And I can type multiple times"),
                            typistSpeed = TypistSpeed.FAST,
                            textStyle = TextStyle(
                                color = Color.Red,
                                fontWeight = FontWeight.Bold,
                                fontSize = 28.sp,
                                textAlign = TextAlign.Center
                            ),
                            isBlinkingCursor = true,
                            isInfiniteCursor = true,
                            isCursorVisible = true,
                        )
                    }
                }
            }
        }
    }
}
