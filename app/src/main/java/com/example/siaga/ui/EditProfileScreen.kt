package com.example.siaga.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
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
import com.example.siaga.ui.theme.Red20

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditProfileScreen(navController: NavController) {
    var email by remember { mutableStateOf("") }
    var username by remember { mutableStateOf("") }
    var phone by remember { mutableStateOf("") }

    Scaffold(
        topBar = {
            TopAppBar(
                { Text("Ubah Profile") },
                navigationIcon = {
                    IconButton({ navController.navigateUp() }) {
                        Icon(Icons.Filled.ArrowBack,null)
                    }
                },
                colors = TopAppBarDefaults.smallTopAppBarColors(Red20)
            )
        },
        content = { innerPadding ->
            Column(
                Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
                    .padding(start = 16.dp, end = 16.dp)
                    .verticalScroll(rememberScrollState()),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spacer(Modifier.height(30.dp))
                Box(
                    Modifier
                        .size(150.dp)
                        .clip(CircleShape)
                        .align(Alignment.CenterHorizontally)
                        .padding(bottom = 15.dp, top = 10.dp)
                ) {
                    Image(
                        painterResource(R.drawable.icon),
                        "Logo"
                    )

                    IconButton(
                        onClick = {},
                        modifier = Modifier
                            .align(Alignment.BottomEnd)
                            .size(50.dp),
                        content = {
                            Icon(
                                painterResource(R.drawable.edit_square),
                                "Ubah",
                                Modifier.size(53.dp)
                            )
                        }
                    )
                }

                Spacer(Modifier.height(40.dp))

                CustomOutlinedTextField(
                    value = username,
                    onValueChange = { username = it },
                    placeholder = "example@mail.com",
                    headerText = "Nama Pengguna",
                    leadingIcon = { Icon(painterResource(R.drawable.profile),"Profile icon") },
                    modifier = Modifier.fillMaxWidth(),
                    isEditable = true
                )

                Spacer(modifier = Modifier.height(16.dp))

                CustomOutlinedTextField(
                    value = phone,
                    onValueChange = { phone = it },
                    placeholder = "example@mail.com",
                    headerText = "Telepon",
                    leadingIcon = { Icon(painterResource(R.drawable.call),"Call icon") },
                    modifier = Modifier.fillMaxWidth(),
                    isEditable = true
                )

                Spacer(modifier = Modifier.height(16.dp))

                CustomOutlinedTextField(
                    value = email,
                    onValueChange = { email = it },
                    placeholder = "example@mail.com",
                    headerText = "Email",
                    leadingIcon = { Icon(painterResource(R.drawable.mail),"Email icon") },
                    modifier = Modifier.fillMaxWidth(),
                    isEditable = true
                )

                Spacer(Modifier.height(40.dp))

                CustomButton(
                    onClick = {},
                    buttonText = "Simpan",
                )
            }
        }
    )
}

