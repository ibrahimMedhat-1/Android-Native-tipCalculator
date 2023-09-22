package com.example.android_native_lemonadeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.android_native_lemonadeapp.ui.theme.Android_Native_LemonadeAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Android_Native_LemonadeAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    LemonadeTree()
                }
            }
        }
    }
}

@Composable
fun MainComposable(modifier: Modifier, drawable: Int, text: String) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Surface(
            modifier = modifier,
            color = Color.Green,
            shape = RoundedCornerShape(16.dp),
        ) {
            Image(
                painter = painterResource(id = drawable),
                contentDescription = null,
            )
        }
        Box(Modifier.height(20.dp))
        Text(
            text = text
        )
    }
}

@Composable
fun LemonadeTree() {
    var state by remember { mutableStateOf(1) }
    val imageResource = when (state) {
        1 -> R.drawable.lemon_tree
        2 -> R.drawable.lemon_squeeze
        3 -> R.drawable.lemon_drink
        else -> R.drawable.lemon_restart
    }
    val stringResource = when (state) {
        1 -> stringResource(R.string.tap_the_lemon_tree_to_select_a_lemon)
        2 -> stringResource(R.string.keep_tapping_the_lemon_to_squeeze_it)
        3 -> stringResource(R.string.tap_the_lemonade_to_drink_it)
        else -> stringResource(R.string.tap_the_empty_glass_to_start_again)
    }
    MainComposable(
        modifier = Modifier.clickable {
            if (state != 4) {
                if(state == 2){
                    val x  = (5..10).random()
                    if(x == 7){
                        state++
                    }
                }else{
                    state++
                }
            } else {
                state = 1
            }
        },
        drawable = imageResource,
        text = stringResource,
    )

}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun Preview() {
    Android_Native_LemonadeAppTheme {
        LemonadeTree()
    }
}