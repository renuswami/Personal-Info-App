package com.renu.personinformationdemo
import android.util.Log
import com.google.firebase.Firebase
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.FirebaseFirestoreException
import com.google.firebase.firestore.firestore
import kotlinx.coroutines.tasks.await

class FirebaseDemoRepo {
    private val db = Firebase.firestore

    fun setInfo(){

        val info = hashMapOf<String, String>(
            "Name" to "Renu Swami",
            "Email" to "renuswami2001@gmail.com",
            "Mobile No" to "8005769904"
        )
        db.collection("Information")
            .document("String")
            .set(info)
    }
    suspend fun getDataFromFireStore(): About {
        val db = FirebaseFirestore.getInstance()
        var about = About()

        try {
            db.collection("about").get().await().map {
                val result = it.toObject(About::class.java)
                about = result
            }
        } catch (e: FirebaseFirestoreException) {
            Log.d("error", "getDataFromFireStore: $e")
        }
        return about
    }
}