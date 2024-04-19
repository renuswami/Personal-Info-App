package com.renu.personinformationdemo

import androidx.lifecycle.ViewModel


class MainDemoViewModel : ViewModel(){

    var firebaseDemoRepo = FirebaseDemoRepo()

    fun setInfo(){
        firebaseDemoRepo.setInfo()
    }
}