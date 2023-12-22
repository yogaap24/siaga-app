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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.siaga.R
import com.example.siaga.ui.theme.Red10

@Composable
fun RegisterScreen(navController: NavController) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }
    val emailError = stringResource(R.string.email_harus_mengandung)
    val passwordError = stringResource(R.string.password_minimal)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(50.dp))

        Image(
            painterResource(id = R.drawable.icon),
            contentDescription = "Logo",
            modifier = Modifier
                .size(150.dp)
                .align(Alignment.CenterHorizontally)
        )

        Spacer(modifier = Modifier.height(40.dp))

        CustomOutlinedTextField(
            value = email,
            onValueChange = { email = it },
            validator = { if (!it.contains("@")) emailError else null },
            placeholder = stringResource(R.string.contoh_mail_com),
            headerText = stringResource(R.string.email),
            leadingIcon = { Icon(painterResource(R.drawable.mail),"Email icon") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        CustomOutlinedTextField(
            value = password,
            onValueChange = { password = it },
            validator = { if (it.length < 8) passwordError else null },
            placeholder = stringResource(R.string.kata_sandi),
            headerText = stringResource(R.string.kata_sandi),
            leadingIcon = { Icon(painterResource(R.drawable.lock),"Lock icon") },
            isPassword = true,
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(16.dp))

        CustomOutlinedTextField(
            value = confirmPassword,
            onValueChange = { confirmPassword = it },
            validator = { if (it.length < 8) passwordError else null },
            placeholder = stringResource(R.string.konfirmasi_kata_sandi),
            headerText = stringResource(R.string.konfirmasi_kata_sandi),
            leadingIcon = { Icon(painterResource(R.drawable.lock),"Lock icon") },
            isPassword = true,
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(40.dp))

        CustomButton(
            onClick = {},
            buttonText = stringResource(R.string.daftar),
        )

        Spacer(modifier = Modifier.weight(1f))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = stringResource(R.string.sudah_punya_akun),
                textAlign = TextAlign.Center
            )
            TextButton(onClick = { navController.navigate("login") }) {
                Text(stringResource(R.string.masuk), color = Red10, fontWeight = FontWeight.Bold, fontSize = 18.sp)
            }
        }

        TextButton(onClick = {}) {
            Text(stringResource(R.string.pemadam), color = Red10, fontWeight = FontWeight.Bold, fontSize = 20.sp)
        }
    }
}

