package com.example.multicalculator.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.multicalculator.Greeting

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {

                }
            }
        }
    }
}

@Composable
fun CalcView(){
    val displayText = remember { mutableStateOf("0") }
    Column(modifier = Modifier.background(color = Color.LightGray)) {
        Row {
            CalcDisplay(displayText)
        }
        Row {
            Column {
                for(num in 7 downTo 1 step 3){
                    CalcRow(displayText, 7, 3)
                }
                Row {
                    CalcNumericButton(0, displayText)
                    CalcEqualsButton(displayText)
                }
            }
            Column {
                val operators = listOf("+", "-", "*", "/")
                for(symbol in operators) {
                    CalcOperationButton(symbol, displayText)
                }
            }
        }
    }

}

@Composable
fun CalcRow(display : MutableState<String>, startNum : Int, numButtons : Int){
    val endNum = startNum + numButtons
    Row(modifier = Modifier.padding(0.dp)) {
        val count = endNum - 1
        for(number in startNum.. count){
            CalcNumericButton(number, display)
        }

    }

}

@Composable
fun CalcDisplay(display : MutableState<String>){
    Text(text =display.value,
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp)
            .padding(5.dp))

}

@Composable
fun CalcNumericButton(number : Int, display : MutableState<String>){
    Button(modifier = Modifier.padding(4.dp),
        onClick = {"${display.value} + $number"}) {
        Text(text = "$number")
        
    }

}
@Composable
fun CalcOperationButton(operation : String, display : MutableState<String>){
    Button(modifier = Modifier.padding(4.dp),
        onClick = { /*TODO*/ }) {
        Text(text = operation)
    }

}
@Composable
fun CalcEqualsButton(display : MutableState<String>){
    Button(modifier = Modifier
        .padding(4.dp)
        , onClick = { "0"}) {
        Text(text = "=")
    }
}

@Preview
@Composable
fun DefaultPreview() {
    MyApplicationTheme {
        CalcView()
    }
}
