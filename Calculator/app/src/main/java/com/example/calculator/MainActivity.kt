package com.example.calculator


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.calculator.ui.theme.CalculatorTheme
import kotlin.math.pow
import kotlin.properties.Delegates

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
           CalculatorTheme {
App()
            }
        }
    }
}

@Preview
@Composable
fun App() {
    var state = rememberSaveable {
        mutableStateOf("0")
    }
    var op = rememberSaveable {
        mutableStateOf("")
    }
    var state2 = rememberSaveable{
        mutableStateOf("")
    }
    val result = rememberSaveable {
        mutableStateOf(0.0000)
    }

    Column(
        modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth()
    ) {
        Text(
            text ="${state.value}${op.value}${state2.value}\n\n\n=${result.value}",
            Modifier
                .fillMaxWidth()
                .fillMaxHeight(.4f), fontSize = 60.sp
        )
        Row(
       horizontalArrangement = Arrangement.SpaceAround,
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth()
        ) {
            Column(verticalArrangement = Arrangement.Center) {
                Row() {
                    Button(onClick = {
                        if (op.value == "") {
                            if (state.value == "0") {
                                state.value = "1"
                            }; else state.value = state.value + "1"
                        }; else state2.value = state2.value + "1"
                    }) {
                        Text(text = "1")
                    }
                    Button(onClick = {
                        if (op.value == "") {
                            if (state.value == "0") {
                                state.value = "2"
                            }; else state.value = state.value + "2"
                        }; else state2.value = state2.value + "2"
                    }) {
                        Text(text = "2")
                    }
                    Button(onClick = {
                        if (op.value == "") {
                            if (state.value == "0") {
                                state.value = "3"
                            }; else state.value = state.value + "3"
                        }; else state2.value = state2.value + "3"
                    }) {
                        Text(text = "3")
                    }
                }
                Row(horizontalArrangement = Arrangement.SpaceBetween) {
                    Button(onClick = {
                        if (op.value == "") {
                            if (state.value == "0") {
                                state.value = "4"
                            }; else state.value = state.value + "4"
                        }; else state2.value = state2.value + "4"
                    }) {
                        Text(text = "4")
                    }
                    Button(onClick = {
                        if (op.value == "") {
                            if (state.value == "0") {
                                state.value = "5"
                            }; else state.value = state.value + "5"
                        }; else state2.value = state2.value + "5"
                    }) {
                        Text(text = "5")
                    }
                    Button(onClick = {
                        if (op.value == "") {
                            if (state.value == "0") {
                                state.value = "6"
                            }; else state.value = state.value + "6"
                        }; else state2.value = state2.value + "6"
                    }) {
                        Text(text = "6")
                    }
                }
                Row(horizontalArrangement = Arrangement.SpaceBetween) {
                    Button(onClick = {
                        if (op.value == "") {
                            if (state.value == "0") {
                                state.value = "7"
                            }; else state.value = state.value + "7"
                        }; else state2.value = state2.value + "7"
                    }) {
                        Text(text = "7")
                    }
                    Button(onClick = {
                        if (op.value == "") {
                            if (state.value == "0") {
                                state.value = "8"
                            }; else state.value = state.value + "8"
                        }; else state2.value = state2.value + "8"
                    }) {
                        Text(text = "8")
                    }
                    Button(onClick = {
                        if (op.value == "") {
                            if (state.value == "0") {
                                state.value = "9"
                            }; else state.value = state.value + "9"
                        }; else state2.value = state2.value + "9"
                    }) {
                        Text(text = "9")
                    }
                }
                Column() {

                    Button(onClick = {
                        if (op.value == "") {
                            if (state.value == "0") {
                                state.value = "0"
                            }; else state.value = state.value + "0"
                        }; else state2.value = state2.value + "0"
                    }, Modifier.width(100.dp)) {
                        Text(text = "0")
                    }

                    Button(onClick = {
                        when (op.value) {
                            "+" -> result.value =
                                state.value.toDouble().plus(state2.value.toDouble())

                            "-" -> result.value =
                                state.value.toDouble().minus(state2.value.toDouble())

                            "*" -> result.value =
                                state.value.toDouble().times(state2.value.toDouble())

                            "/" -> result.value =
                                state.value.toDouble().div(state2.value.toDouble())

                            "%" -> result.value =
                                state.value.toDouble().mod(state2.value.toDouble())

                            "^" -> result.value =
                                state.value.toDouble().pow(state2.value.toDouble())
                        }
                    })
                    {
                        Text(text = "=")
                    }
                }
            }
            Column() {
                Row {
                    Button(onClick = {
                        if (state2.value == "" && op.value == "") {
                            state.value = state.value.dropLast(1)
                        }; else if (state2.value != "") {
                            state2.value = state2.value.dropLast(1)
                        }; else if (state2.value == "" && op.value != "") {
                            op.value = op.value.dropLast(1)
                        }
                    }) {
                        Text(text = "X")
                    }
                    Button(onClick = { state.value = "";state2.value = "";op.value = "" }) {
                        Text(text = "AC")
                    }
                }
                Row(horizontalArrangement = Arrangement.SpaceBetween) {
                    Button(onClick = { op.value = op.value + "+" }) {
                        Text(text = "+")
                    }
                    Button(onClick = { op.value = op.value + "-" }) {
                        Text(text = "-")
                    }
                }
                Row(horizontalArrangement = Arrangement.SpaceBetween) {
                    Button(onClick = { op.value = op.value + "*" }) {
                        Text(text = "*")
                    }
                    Button(onClick = { op.value = op.value + "/" }) {
                        Text(text = "/")
                    }
                }
                Row(horizontalArrangement = Arrangement.SpaceBetween) {
                    Button(onClick = { op.value = op.value + "%" }) {
                        Text(text = "%")
                    }
                    Button(onClick = { op.value = op.value + "^" }) {
                        Text(text = "^")
                    }
                }
            }
    }
}}

