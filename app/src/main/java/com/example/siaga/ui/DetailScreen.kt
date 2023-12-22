package com.example.siaga.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.rememberNavController
import com.example.siaga.R

@Composable
fun DetailScreen(deviceName: String?) {
    val data = getData(deviceName)

    val details = listOf(
        Pair("Lokasi", painterResource(R.drawable.location)),
        Pair("Jaringan", painterResource(R.drawable.wifi)),
        Pair("Lantai", painterResource(R.drawable.floor)),
        Pair("Ketebalan Asap", painterResource(R.drawable.smoke)),
        Pair("Kelembaban", painterResource(R.drawable.moisture)),
        Pair("Karbondioksida", painterResource(R.drawable.co2)),
        Pair("Suhu Ruangan", painterResource(R.drawable.temperature)),
        Pair("Terdeteksi Api", painterResource(R.drawable.fire))
    )

    val deviceNameState = remember { mutableStateOf(deviceName ?: "") }
    val isEditing = remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .padding(16.dp)
            .verticalScroll(rememberScrollState())) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.End
        ) {
            IconButton(onClick = { }) {
                Icon(painterResource(R.drawable.wifi), null, Modifier.size(20.dp))
            }
            IconButton(onClick = { isEditing.value = true }) {
                Icon(painterResource(R.drawable.edit_square), null, Modifier.size(53.dp))
            }
        }
        Spacer(modifier = Modifier.height(5.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
        ) {
            CustomCard(
                isOnline = true,
                deviceName = deviceNameState.value,
                title = deviceNameState.value,
                navController = rememberNavController(),
                isClickable = false
            )
            Spacer(modifier = Modifier.width(16.dp))
            Column {
                TextField(
                    value = deviceNameState.value,
                    onValueChange = { deviceNameState.value = it },
                    label = { Text(stringResource(R.string.nama_perangkat)) },
                    modifier = Modifier.fillMaxWidth(),
                    readOnly = !isEditing.value,
                    trailingIcon = {
                        if (isEditing.value) {
                            IconButton(onClick = { isEditing.value = false }) {
                                Icon(painterResource(R.drawable.check), "Save")
                            }
                        }
                    }
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text("#Device00001", fontWeight = FontWeight.Black, fontSize = 20.sp)
            }
        }

        Spacer(modifier = Modifier.height(8.dp))
        for (detail in details) {
            DetailRow(detail.first, data[detail.first], detail.second)
        }
    }
}


@Composable
fun DetailRow(label: String, value: String?, icon: Painter) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(painter = icon, contentDescription = null, modifier = Modifier.size(24.dp))
        Spacer(modifier = Modifier.width(8.dp))
        Box(modifier = Modifier.width(170.dp)) {
            Text(text = label, fontSize = 18.sp, fontWeight = FontWeight.Bold)
        }
        Text(text = ":", fontSize = 18.sp, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.width(8.dp))
        Box(modifier = Modifier.fillMaxWidth()) {
            Text(text = value ?: "N/A", fontSize = 14.sp)
        }
    }
}

fun getData(deviceName: String?): Map<String, String> {
    return mapOf(
        "Lokasi" to "JL Contoh, Kec Contoh, Surabaya, Jawa Timur, 00000",
        "Jaringan" to "SIAGA",
        "Lantai" to "2",
        "Ketebalan Asap" to "Tipis",
        "Kelembaban" to "50.73",
        "Karbondioksida" to "400",
        "Suhu Ruangan" to "25°C",
        "Terdeteksi Api" to "Tidak"
    )
}

