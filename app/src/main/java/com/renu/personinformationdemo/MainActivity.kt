package com.renu.personinformationdemo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.magnifier
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.renu.personinformationdemo.ui.theme.PersonInformationDemoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            val mainDemoViewModel : MainDemoViewModel by viewModels()
            val getData = mainDemoViewModel.state.value

            PersonInformationDemoTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Box(modifier = Modifier.fillMaxSize(),
                        ) {
                        Column(
                            modifier = Modifier.align(Alignment.Center),
                            verticalArrangement = Arrangement.Center
                        ) {
                            Column(
                                horizontalAlignment = Alignment.CenterHorizontally,
                                verticalArrangement = Arrangement.Center
                            ) {
                                Button(onClick = { mainDemoViewModel.setInfo() }) {
                                    Text(text = "Set Data")
                                }
                            }
                            Column(
                                horizontalAlignment = Alignment.CenterHorizontally,
                                verticalArrangement = Arrangement.Center
                            ) {
                                mainDemoViewModel.getData()
                                getData.let { info ->
                                    Text(text = info.name)
                                    Text(text = info.email)
                                    Text(text = info.age)
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

