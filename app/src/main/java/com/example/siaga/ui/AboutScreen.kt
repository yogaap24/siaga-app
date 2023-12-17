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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.siaga.R
import com.example.siaga.ui.theme.Red20

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AboutScreen(navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(
                { Text("About Us") },
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
                Image(
                    painterResource(R.drawable.icon),
                   "Logo",
                    Modifier
                        .size(220.dp)
                        .align(Alignment.CenterHorizontally)
                )
                Spacer(Modifier.height(30.dp))
                Text("Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.",
                    textAlign = TextAlign.Justify)
                Spacer(Modifier.height(30.dp))
                Text("Hubungi Kami", fontWeight = FontWeight.Black)
                Row(
                    Modifier.fillMaxWidth(),
                    Arrangement.Center,
                    Alignment.CenterVertically
                ) {
                    IconButton({}) {
                        Icon(painterResource(R.drawable.instagram), "Instagram",Modifier.size(40.dp),Color.Unspecified)
                    }
                    IconButton({}) {
                        Icon(painterResource(R.drawable.facebook),"Settings",Modifier.size(40.dp),Color.Unspecified)
                    }
                    IconButton({}) {
                        Icon(painterResource(R.drawable.linkedin),"Settings",Modifier.size(40.dp),Color.Unspecified)
                    }
                }
            }
        }
    )
}