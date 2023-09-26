package com.androidfactory.githubactionsdemo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.androidfactory.githubactionsdemo.ui.theme.GitHubActionsDemoTheme
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GitHubActionsDemoTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.primaryContainer
                ) {
                    var currentColor: Color by remember { mutableStateOf(Color.Black) }

                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Spacer(modifier = Modifier.height(64.dp))
                        ColorDisplay(color = currentColor)
                        Spacer(modifier = Modifier.height(32.dp))
                        Button(onClick = { currentColor = generateRandomColor() }) {
                            Text(text = "Generate new color")
                        }
                    }
                }
            }
        }
    }

    private fun generateRandomColor(): Color {
        return Color(
            red = Random.nextInt(0, 255),
            blue = Random.nextInt(0, 255),
            green = Random.nextInt(0, 255),
        )
    }
}

@Composable
fun ColorDisplay(color: Color) {
    Column(
        modifier = Modifier
            .background(color = Color.LightGray, shape = RoundedCornerShape(8.dp))
            .padding(all = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .size(250.dp)
                .background(color = color, shape = RoundedCornerShape(8.dp))
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = "RGB(${(color.red * 255).toInt()}, ${(color.green * 255).toInt()}, ${(color.blue * 255).toInt()})", color = Color.Black)
    }
}