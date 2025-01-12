package com.altaygunbatan.uni_verse.ui

import android.widget.Toast
import androidx.compose.material.AlertDialog
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import com.google.firebase.auth.FirebaseAuth


fun sendPasswordResetEmail(email: String, callback: (Boolean, String?) -> Unit) {
    if (email.isEmpty()) {
        callback(false, "Please enter your email.")
        return
    }

    FirebaseAuth.getInstance().sendPasswordResetEmail(email)
        .addOnCompleteListener { task ->
            if (task.isSuccessful) {
                callback(true, null)
            } else {
                callback(false, task.exception?.localizedMessage)
            }
        }
}


fun signUpWithEmailAndPassword(email: String, password: String, onResult: (Boolean, String?) -> Unit) {
    val auth = FirebaseAuth.getInstance()
    auth.createUserWithEmailAndPassword(email, password)
        .addOnCompleteListener { task ->
            if (task.isSuccessful) {
                onResult(true, null)
            } else {
                onResult(false, task.exception?.message)
            }
        }
}

fun signInWithEmailAndPassword(email: String, password: String, onResult: (Boolean, String?) -> Unit) {
    val auth = FirebaseAuth.getInstance()
    auth.signInWithEmailAndPassword(email, password)
        .addOnCompleteListener { task ->
            if (task.isSuccessful) {
                onResult(true, null)
            } else {
                onResult(false, task.exception?.message)
            }
        }
}


@Composable
fun DeleteButtonWithConfirmation(onDelete: () -> Unit) {
    var showDialog by remember { mutableStateOf(false) }  // Controls AlertDialog visibility
    val context = LocalContext.current  // For showing Toast

    // Trash Icon Button
    IconButton(onClick = {
        showDialog = true  // Show confirmation dialog
    }) {
        Icon(
            imageVector = Icons.Default.Delete,
            contentDescription = "Delete",
            tint = Color.Red
        )
    }

    // Confirmation AlertDialog
    if (showDialog) {
        AlertDialog(
            onDismissRequest = { showDialog = false },  // Close dialog if tapped outside
            title = { Text(text = "Delete Confirmation") },
            text = { Text("Are you sure you want to delete this item?") },
            confirmButton = {
                TextButton(
                    onClick = {
                        onDelete()  // Execute the delete action
                        Toast.makeText(context, "Item deleted", Toast.LENGTH_SHORT).show()  // Show Toast
                        showDialog = false  // Close the dialog
                    }
                ) {
                    Text("Delete", color = Color.Red)
                }
            },
            dismissButton = {
                TextButton(
                    onClick = {
                        showDialog = false  // Close the dialog without deleting
                    }
                ) {
                    Text("Cancel")
                }
            }
        )
    }
}