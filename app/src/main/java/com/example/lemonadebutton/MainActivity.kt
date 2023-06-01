package com.example.lemonadebutton


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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
fun LemonadeButton(modifier: Modifier = Modifier

) {
    //So we are gonna make one button that cycles thru several buttons
    //a when statement that counts the number of times clicked
    //button has to change layout depending on which state of the when statement it is in
    var stateCount by remember { mutableStateOf(1) }  //remember to get runtime get/set value import
    val lemonSqueezeRNG: Int = (2..4).random()
    var clickCount = 0
    var imageID = R.drawable.lemon_tree
    var textID = R.string.tree_text

    //Keeps track of the text and image state
    when(stateCount){
        1-> {
            imageID = R.drawable.lemon_tree
            textID = R.string.tree_text
        }
        2->{
            imageID = R.drawable.lemon_squeeze
            textID = R.string.lemon_squeeze
        }
        3->{
            imageID = R.drawable.lemon_drink
            textID = R.string.drink
        }
        4->{
            imageID = R.drawable.lemon_restart
            textID = R.string.restart
        }
    }


    Row(
        modifier = modifier,
        verticalAlignment = Alignment.Top,
        horizontalArrangement = Arrangement.Center
    ){

        Text(
            modifier= modifier
                .fillMaxWidth()
                .background(Color.Yellow)
                .padding(24.dp),
            text = "Lemonade",
            fontSize = 24.sp,
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold



        )
    }

    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally

    ) {


        Button(onClick = {/* put click increment logic here*/
            if(stateCount == 2) {
                clickCount++
                if (clickCount >= lemonSqueezeRNG)
                    stateCount++
            }
            else if(stateCount == 4)
                stateCount = 1
            else
                stateCount++
        }) {
            Image(
                modifier = modifier.padding(8.dp),
                painter = painterResource(id = imageID),
                contentDescription = "Tree"
            )
        }
        Text(
            text = stringResource(id = textID),
            modifier = modifier
                .padding(top = 16.dp)

            )
    }
    
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
        Image(
            painter = painterResource(R.drawable.lemon_tree),
            contentDescription = "Tree"
        )
    }
}