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
            "Name" to "",
            "Email" to "",
            "Mobile No" to ""
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