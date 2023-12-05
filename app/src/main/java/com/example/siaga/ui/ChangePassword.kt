package com.example.siaga.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.siaga.R
import com.example.siaga.ui.theme.Red20

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ChangePassword(navController: NavController) {
    var oldpassword by remember { mutableStateOf("") }
    var newpassword by remember { mutableStateOf("") }
    var confpassword by remember { mutableStateOf("") }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Ubah Password") },
                navigationIcon = {
                    IconButton(onClick = { navController.navigateUp() }) {
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

                CustomOutlinedTextField(
                    value = oldpassword,
                    onValueChange = { oldpassword = it },
                    validator = { if (it.length < 8) "Password minimal harus 8 karakter" else null },
                    placeholder = "Kata Sandi Lama",
                    headerText = "Kata Sandi Lama",
                    leadingIcon = { Icon(painterResource(R.drawable.lock),"Password Icon") },
                    isPassword = true,
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(modifier = Modifier.height(16.dp))

                CustomOutlinedTextField(
                    value = newpassword,
                    onValueChange = { newpassword = it },
                    validator = { if (it.length < 8) "Password minimal harus 8 karakter" else null },
                    placeholder = "Kata Sandi Baru",
                    headerText = "Kata Sandi Baru",
                    leadingIcon = { Icon(painterResource(R.drawable.lock),"Password Icon") },
                    isPassword = true,
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(modifier = Modifier.height(16.dp))

                CustomOutlinedTextField(
                    value = confpassword,
                    onValueChange = { confpassword = it },
                    validator = { if (it != newpassword) "Konfirmasi password harus sama" else null },
                    placeholder = "Konfirmasi Kata Sandi",
                    headerText = "Konfirmasi Kata Sandi",
                    leadingIcon = { Icon(painterResource(R.drawable.lock),"Password Icon") },
                    isPassword = true,
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(Modifier.height(40.dp))

                CustomButton(
                   {},
                    "Simpan",
                )
            }
        }
    )
}
