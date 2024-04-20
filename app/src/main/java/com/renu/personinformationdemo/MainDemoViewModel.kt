package com.renu.personinformationdemo

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import kotlinx.coroutines.launch

class MainDemoViewModel : ViewModel(){

    val about = mutableStateOf(About())
    var firebaseDemoRepo = FirebaseDemoRepo()

    fun setInfo(){
        firebaseDemoRepo.setInfo(about.value)
    }

    fun getInfo(){

        viewModelScope.launch {
            about.value = firebaseDemoRepo.getInfo()!!
        }
       // Log.e("TAG", about.value.toString()) // to print output on log screen
    }
}





