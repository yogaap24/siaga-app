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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.siaga.R

@Composable
fun ProfileScreen(navController: NavController) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var username by remember { mutableStateOf("") }
    var phone by remember { mutableStateOf("") }

    Column(
        Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(Modifier.height(10.dp))

        Row(
            Modifier.fillMaxWidth(),
            Arrangement.End,
            Alignment.CenterVertically
        ) {
            IconButton({ navController.navigate("edit_profile") }) {
                Icon(painterResource(R.drawable.edit_square), "Edit", Modifier.size(53.dp))
            }
            IconButton({ navController.navigate("setting")}) {
                Icon(painterResource(R.drawable.setting),"Settings",Modifier.size(30.dp))
            }
        }
        Spacer(Modifier.height(30.dp))

        Image(
            painterResource(R.drawable.icon),
            "Logo",
            Modifier
                .size(150.dp)
                .clip(CircleShape)
                .align(Alignment.CenterHorizontally)
        )

        Spacer(Modifier.height(40.dp))

        CustomOutlinedTextField(
            value = username,
            onValueChange = { username = it },
            placeholder = "example@mail.com",
            headerText = "Nama Pengguna",
            leadingIcon = { Icon(painterResource(R.drawable.profile),"Profile icon") },
            modifier = Modifier.fillMaxWidth(),
            isEditable = false
        )

        Spacer(Modifier.height(16.dp))

        CustomOutlinedTextField(
            value = phone,
            onValueChange = { phone = it },
            placeholder = "example@mail.com",
            headerText = "Telepon",
            leadingIcon = { Icon(painterResource(R.drawable.call),"Call icon") },
            modifier = Modifier.fillMaxWidth(),
            isEditable = false
        )

        Spacer(modifier = Modifier.height(16.dp))

        CustomOutlinedTextField(
            value = email,
            onValueChange = { email = it },
            placeholder = "example@mail.com",
            headerText = "Email",
            leadingIcon = { Icon(painterResource(R.drawable.mail),"Email icon") },
            modifier = Modifier.fillMaxWidth(),
            isEditable = false
        )

        Spacer(Modifier.height(16.dp))

        CustomOutlinedTextField(
            value = password,
            onValueChange = { password = it },
            placeholder = "Kata Sandi",
            headerText = "Kata Sandi",
            leadingIcon = { Icon(painterResource(R.drawable.lock),"Password Icon") },
            isPassword = true,
            modifier = Modifier.fillMaxWidth(),
            isEditable = false
        )
    }
}
