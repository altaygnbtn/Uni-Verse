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

    private val auth = Firebase.auth //create an instance of FirebaseAuth

    //create an account using user's email and check if it is valid
    fun createAccountWithEmail(email: String, password: String): Flow<AuthResponse> = callbackFlow {

        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->        //added listener to check if the task is successful
                if (task.isSuccessful) {
                    trySend(AuthResponse.Success) //if it is successful, send success using non-blocking method trySend
                } else {
                    trySend(AuthResponse.Error(message = task.exception?.message ?:""))  //if it is not successful, send error using non-blocking method trySend
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
                    trySend(AuthResponse.Error(message = task.exception?.message ?:"Login Failed! Please check your credentials.")) //error message
                }
            }
        awaitClose() //suspends the coroutine until the channel is closed
    }

}
interface AuthResponse {     //created interface to hold the status of an action
    data object Success : AuthResponse
    data class Error(val message: String) : AuthResponse
}


