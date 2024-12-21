package com.altaygunbatan.uni_verse.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow

class AuthViewModel: ViewModel() {

    private val auth = Firebase.auth

    fun createAccountWithEmail(email: String, password: String): Flow<AuthResponse> = callbackFlow {

        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    trySend(AuthResponse.Success)
                } else {
                    trySend(AuthResponse.Error(message = task.exception?.message ?:""))
                }
            }
        awaitClose()
    }

    fun loginWithEmail(email: String, password: String): Flow<AuthResponse> = callbackFlow {
        auth.signInWithEmailAndPassword(email,password)
            .addOnCompleteListener { task->
                if (task.isSuccessful) {
                    trySend(AuthResponse.Success)
                } else {
                    trySend(AuthResponse.Error(message = task.exception?.message ?:""))
                }
            }
        awaitClose()
    }

}
interface AuthResponse {
    data object Success : AuthResponse
    data class Error(val message: String) : AuthResponse
}


