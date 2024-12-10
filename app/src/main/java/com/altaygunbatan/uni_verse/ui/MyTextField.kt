package com.altaygunbatan.uni_verse.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.altaygunbatan.uni_verse.ui.theme.UniVerseTheme


@Composable
fun MyTextField(onChange:(String) -> Unit) {
    TextField(modifier = Modifier.size(width = 345.dp, height = 45.dp),
        value = "",
        onValueChange = onChange)
}


@Composable
fun MyButton(text: String, onChange: () -> Unit) {
    Button(onClick = onChange,
        modifier = Modifier.background(color = MaterialTheme.colorScheme.)) {
        Text(text = text)

    }
}