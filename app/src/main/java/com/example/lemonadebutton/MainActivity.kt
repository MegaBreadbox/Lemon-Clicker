package com.example.lemonadebutton

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.lemonadebutton.ui.theme.LemonadeButtonTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LemonadeButtonTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    LemonadeButton()
                }
            }
        }
    }
}

@Composable
fun LemonadeButton(modifier: Modifier = Modifier) {
    //So we are gonna make one button that cycles thru several buttons
    //a when statement that counts the number of times clicked
    //button has to change layout depending on which state of the when statement it is in
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    LemonadeButtonTheme {
        LemonadeButton()
    }
}

@Composable
fun ButtonLayout(imageNumber: Int, lemonDescription: String, modifier: Modifier = Modifier){
    Column() {
        image = painterResource
    }
}