package com.renu.personinformationdemo

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class MainDemoViewModel : ViewModel(){

    val state = mutableStateOf(About())
    var firebaseDemoRepo = FirebaseDemoRepo()

    fun setInfo(){
        firebaseDemoRepo.setInfo()
    }

    init {
        getData()
    }
    fun getData(){

        viewModelScope.launch {
            state.value = firebaseDemoRepo.getDataFromFireStore()
        }
    }
}





