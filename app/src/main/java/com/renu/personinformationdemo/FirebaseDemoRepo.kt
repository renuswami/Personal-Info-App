package com.renu.personinformationdemo
import android.util.Log
import com.google.firebase.Firebase
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.FirebaseFirestoreException
import com.google.firebase.firestore.firestore
import com.google.firebase.firestore.toObject
import kotlinx.coroutines.tasks.await

class FirebaseDemoRepo {
    private val db = Firebase.firestore

    fun setInfo(about: About){

        val info = hashMapOf<String, String>(
            "Name" to "Renu Swami",
            "Email" to "renuswami2001@gmail.com",
            "Mobile No" to "8005769904"
        )
        db.collection("Information")
            .document("String")
            .set(about)
    }

    suspend fun getInfo(): About?{
        return db.collection("Information")
            .document("String")
            .get()
            .await()
            .toObject(About::class.java)
    }
}