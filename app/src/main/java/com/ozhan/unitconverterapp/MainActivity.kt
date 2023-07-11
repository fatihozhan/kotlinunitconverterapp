package com.ozhan.unitconverterapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.ozhan.unitconverterapp.ui.theme.UnitConverterAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            UnitConverterAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    var myViewModel: MyViewModel = MyViewModel()
                    MainScreen(myViewModel)
                }
            }
        }
    }
}

@Composable
fun MainScreen(myViewModel: MyViewModel) {
    var inputTemp by remember { mutableStateOf("0") }
    Column(horizontalAlignment = Alignment.CenterHorizontally) {

        Text(text = "Unit Converter App", fontSize = 32.sp)
        OutlinedTextField(
            value = inputTemp,
            onValueChange = { enteredTemp: String -> inputTemp = enteredTemp },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            label = { Text(text = "Enter Temp.") },
            singleLine = true

        )
        Button(onClick = { myViewModel.convertTemp(inputTemp) }) {
            Text(text = "Convert Now")
        }
        Text(text = "The Degree in Celcius : \n ${myViewModel.tempC}", fontSize = 32.sp)
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    UnitConverterAppTheme {
        val myViewModel: MyViewModel = MyViewModel()
        MainScreen(myViewModel)
    }
}