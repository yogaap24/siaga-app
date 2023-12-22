package com.example.siaga.ui.setting

import android.util.Log
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
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.siaga.R

data class ListItem(val icon: Int, val title: String, val destination: String)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SettingScreen(navController: NavController) {
    val viewModel: SettingsViewModel = viewModel()
    val context = LocalContext.current

    val bahasa = stringResource(R.string.bahasa)

    val listItems = listOf(
        ListItem(R.drawable.change_pass, stringResource(R.string.ubah_kata_sandi), "change_password"),
        ListItem(R.drawable.globe, bahasa, ""),
        ListItem(R.drawable.about, stringResource(R.string.tentang_kami), "about")
    )

    LaunchedEffect(Unit) {
        viewModel.loadLanguagePreference(context)
    }
    val showDialog = remember { mutableStateOf(false) }

    Column {
        TopAppBar(
            { Text(stringResource(R.string.pengaturan)) },
            navigationIcon = {
                IconButton({ navController.navigateUp() }) {
                    Icon(Icons.Filled.ArrowBack, null)
                }
            },
            colors = TopAppBarDefaults.smallTopAppBarColors(Color.Red)
        )

        if (showDialog.value) {
            AlertDialog(
                onDismissRequest = { showDialog.value = false },
                title = { Text(stringResource(R.string.pilih_bahasa)) },
                text = {
                    Column {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            RadioButton(
                                selected = viewModel.selectedLanguage.value == "Indonesia",
                                onClick = { viewModel.onLanguageSelected("Indonesia") },
                                colors = RadioButtonDefaults.colors(
                                    selectedColor = Color.Red,
                                    unselectedColor = Color.Gray
                                )
                            )
                            Text("Indonesia")
                        }
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            RadioButton(
                                selected = viewModel.selectedLanguage.value == "English",
                                onClick = { viewModel.onLanguageSelected("English") },
                                colors = RadioButtonDefaults.colors(
                                    selectedColor = Color.Red,
                                    unselectedColor = Color.Gray
                                )
                            )
                            Text("English")
                        }
                    }
                },
                confirmButton = {
                    TextButton(onClick = {
                        viewModel.saveLanguagePreference(context, viewModel.selectedLanguage.value)
                        showDialog.value = false
                    }) {
                        Text("OK")
                    }
                },
                dismissButton = {
                    TextButton(onClick = {
                        showDialog.value = false
                    }) {
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
                            if (item.title == bahasa) {
                                showDialog.value = true
                            } else {
                                navController.navigate(item.destination)
                            }
                        }),
                    colors = CardDefaults.cardColors(containerColor = Color.Transparent)
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