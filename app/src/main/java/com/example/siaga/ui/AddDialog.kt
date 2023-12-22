package com.example.siaga.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun AddDialog(showDialog: MutableState<Boolean>) {
    var productName by remember { mutableStateOf("") }
    var deviceName by remember { mutableStateOf("") }

    if (showDialog.value) {
        AlertDialog(
            onDismissRequest = { showDialog.value = false },
            title = { Text("Tambah Device") },
            text = {
                Column {
                    CustomOutlinedTextField(
                        value = productName,
                        onValueChange = { productName = it },
                        placeholder = "SIAGA FIRE",
                        headerText = "Nama Produk"
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    CustomOutlinedTextField(
                        value = deviceName,
                        onValueChange = { deviceName = it },
                        placeholder = "kamar Tidur",
                        headerText = "Nama Perangkat"
                    )
                }
            },
            dismissButton = {
                CustomButton(
                    onClick = { showDialog.value = false },
                    buttonText = "Batal",
                )
            },
            confirmButton = {
                CustomButton(
                    onClick = { },
                    buttonText = "Pilih Jaringan",
                    fontSize = 11.sp
                )
            }
        )
    }
}

