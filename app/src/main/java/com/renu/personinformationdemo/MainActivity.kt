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
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewModelScope
import com.renu.personinformationdemo.ui.theme.PersonInformationDemoTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            val mainDemoViewModel: MainDemoViewModel by viewModels()

            PersonInformationDemoTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Box(
                        modifier = Modifier.fillMaxSize(),
                    ) {
                        Column(
                            modifier = Modifier.align(Alignment.Center),
                            verticalArrangement = Arrangement.Center
                        ) {
                            Button(onClick = { mainDemoViewModel.setInfo() }) {
                                Text(text = "Set Data")
                            }
                            Button(onClick = { mainDemoViewModel.getInfo() }) {
                                Text(text = "Get Data")
                            }
                            val info = mainDemoViewModel.about.value
                            Text(text = info.name, style = TextStyle(fontSize = 20.sp))
                            Text(text = info.email, style = TextStyle(fontSize = 20.sp))
                            Text(text = info.age, style = TextStyle(fontSize = 20.sp))
                        }
                    }
                }
            }
        }
    }
}

