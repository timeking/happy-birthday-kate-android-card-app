package ru.siriuts.codelabs.happybirthdaykate

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.siriuts.codelabs.happybirthdaykate.ui.theme.HappyBirthdayKateTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            HappyBirthdayKateTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    GreetingImage(
                        message = stringResource(R.string.greet),
                        from = stringResource(R.string.greet_from),
                        modifier = Modifier.padding(8.dp)
                    )
                }
            }
        }
    }
}


@Composable
fun GreetingText(message: String, from: String, modifier: Modifier = Modifier) {
    Column(
        modifier,
        verticalArrangement = Arrangement.Center
    ) {
        val fancyShadow = Shadow(
            color = Color.DarkGray,
            offset = Offset(5.0f, 10.0f),
            blurRadius = 3f
        )
        val color = Color.hsv(60f, 0.14f, 0.85f)
        Text(
            text = message,
            color = color,
            lineHeight = 90.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .padding(top = 16.dp)
                .padding(end = 16.dp)
                .align(alignment = Alignment.CenterHorizontally),
            style = TextStyle(
                fontSize = 70.sp,
                shadow = fancyShadow
            )

        )
        Text(
            modifier = Modifier
                .padding(16.dp)
                .align(alignment = Alignment.CenterHorizontally),
            text = from,
            color = color,
            style = TextStyle(
                fontSize = 36.sp,
                shadow = fancyShadow
            )

        )
    }

}


@Composable
fun GreetingImage(message: String, from: String, modifier: Modifier = Modifier) {
    val image = painterResource(R.drawable.ballons)
    Box(modifier) {
        Image(
            painter = image,
            contentDescription = null,
            //modifier = modifier.fillMaxSize(),
            contentScale = ContentScale.Crop,
            alpha = 0.5f
        )
        GreetingText(
            message = message,
            from = from,
            modifier = modifier
                .fillMaxSize()
                .padding(8.dp)
        )
    }
}



@Preview(showBackground = true, locale = "ru")
@Composable
fun GreetingPreview() {
    HappyBirthdayKateTheme {
        GreetingImage(
            message = stringResource(R.string.greet),
            from = stringResource(R.string.greet_from),
        )
    }
}

