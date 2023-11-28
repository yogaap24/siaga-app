package com.example.siaga.ui

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.example.siaga.R

@Composable
fun LoginPage() {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    CustomTextField(
        value = email,
        onValueChange = { email = it },
        label = "Email",
        icon = R.drawable.Lock
    )

    CustomTextField(
        value = password,
        onValueChange = { password = it },
        label = "Password",
        icon = R.drawable.Lock,
        isPassword = true
    )
}
