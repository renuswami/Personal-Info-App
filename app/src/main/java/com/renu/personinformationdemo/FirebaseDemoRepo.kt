package com.renu.personinformationdemo

import com.google.firebase.Firebase
import com.google.firebase.firestore.firestore

class FirebaseDemoRepo {

    val db = Firebase.firestore

    fun setInfo(){

        val info = hashMapOf<String, String>(
            "Name" to "Renu Swami",
            "Email" to "renuswami2001@gmail.com",
            "Mobile No" to "8005769900"
        )
        db.collection("Information")
            .document("String")
            .set(info)
    }
}