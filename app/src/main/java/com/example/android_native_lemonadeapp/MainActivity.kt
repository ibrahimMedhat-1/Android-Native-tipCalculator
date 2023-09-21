package com.example.android_native_lemonadeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
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
fun LemonadeTree(modifier: Modifier = Modifier) {
    Column(modifier = modifier) {

    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun Preview() {
    Android_Native_LemonadeAppTheme {
        LemonadeTree()
    }
}