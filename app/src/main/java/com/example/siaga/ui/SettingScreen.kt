package com.example.siaga.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.siaga.R
import com.example.siaga.ui.theme.Red20

data class ListItem(val icon: Int, val title: String, val destination: String)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SettingScreen(navController: NavController) {
    val listItems = listOf(
        ListItem(R.drawable.change_pass, "Ubah Kata Sandi", "change_password"),
        ListItem(R.drawable.globe, "Bahasa", ""),
        ListItem(R.drawable.about, "Tentang Kami", "about")
    )

    val showDialog = remember { mutableStateOf(false) }
    val selectedLanguage = remember { mutableStateOf("Bahasa Indonesia") }

    Column {
        TopAppBar(
            { Text("Pengaturan") },
            navigationIcon = {
                IconButton({ navController.navigateUp() }) {
                    Icon(Icons.Filled.ArrowBack,null)
                }
            },
            colors = TopAppBarDefaults.smallTopAppBarColors(Red20)
        )

        if (showDialog.value) {
            AlertDialog(
                onDismissRequest = { showDialog.value = false },
                title = { Text("Pilih Bahasa") },
                text = {
                    Column {
                        Row(
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            RadioButton(
                                selected = selectedLanguage.value == "Bahasa Indonesia",
                                onClick = {
                                    selectedLanguage.value = "Bahasa Indonesia"
                                }
                            )
                            Text("Bahasa Indonesia")
                        }
                        Row(
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            RadioButton(
                                selected = selectedLanguage.value == "Bahasa Inggris",
                                onClick = {
                                    selectedLanguage.value = "Bahasa Inggris"
                                }
                            )
                            Text("Bahasa Inggris")
                        }
                    }
                },
                confirmButton = {
                    TextButton(onClick = { showDialog.value = false }) {
                        Text("OK")
                    }
                },
                dismissButton = {
                    TextButton(onClick = { showDialog.value = false }) {
                        Text("Cancel")
                    }
                }
            )
        }

        LazyColumn {
            items(listItems) { item ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable(onClick = {
                            if (item.title == "Bahasa") {
                                showDialog.value = true
                            } else {
                                navController.navigate(item.destination)
                            }
                        }),
                    colors = CardDefaults.cardColors(
                        containerColor = Color.Transparent,
                    )
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.padding(16.dp)
                    ) {
                        Icon(
                            painter = painterResource(id = item.icon),
                            contentDescription = null,
                            modifier = Modifier.size(24.dp)
                        )
                        Spacer(modifier = Modifier.width(16.dp))
                        Text(
                            text = item.title,
                            fontWeight = FontWeight.Black
                        )
                    }
                }
            }
        }
    }
}

