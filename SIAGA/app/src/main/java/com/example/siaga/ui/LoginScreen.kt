package com.example.siaga.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.siaga.R
import com.example.siaga.ui.theme.Red20
import com.example.siaga.ui.theme.SIAGATheme

@Composable
fun LoginScreen(navController: NavController) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(50.dp))

        Image(
            painter = painterResource(id = R.drawable.icon),
            contentDescription = "Logo",
            modifier = Modifier
                .size(150.dp)
                .align(Alignment.CenterHorizontally)
        )

        Spacer(modifier = Modifier.height(40.dp))

        CustomOutlinedTextField(
            value = email,
            onValueChange = { email = it },
            validator = { if (!it.contains("@")) "Email harus mengandung @" else null },
            label = "Email",
            headerText = "Email",
            leadingIcon = { Icon(Icons.Default.Email, contentDescription = "Email icon") },
            modifier = Modifier.fillMaxWidth()

        )

        Spacer(modifier = Modifier.height(16.dp))

        CustomOutlinedTextField(
            value = password,
            onValueChange = { password = it },
            validator = { if (it.length < 8) "Password minimal harus 8 karakter" else null },
            label = "Kata Sandi",
            headerText = "Kata Sandi",
            leadingIcon = { Icon(Icons.Default.Lock, contentDescription = "Lock icon") },
            isPassword = true,
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(40.dp))

        CustomButton(
            onClick = {},
            buttonText = "Masuk",
        )


        Spacer(modifier = Modifier.weight(1f))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Belum punya akun?",
                textAlign = TextAlign.Center
            )
            TextButton(onClick = { navController.navigate("register") }) {
                Text("Register", color = Red20, fontWeight = FontWeight.Bold, fontSize = 18.sp)
            }
        }

        TextButton(onClick = {}) {
            Text("Pemadam", color = Red20, fontWeight = FontWeight.Bold, fontSize = 20.sp)
        }
    }
}


