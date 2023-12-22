package com.example.siaga.ui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.siaga.R
import com.example.siaga.ui.theme.Red40
import com.example.siaga.ui.theme.Red50
import java.util.Locale

@Composable
fun getDeviceIcon(deviceName: String): Painter {
    return when {
        deviceName.toLowerCase(Locale.ROOT).contains("kamar") || deviceName.toLowerCase(Locale.ROOT).contains("bed") -> painterResource(R.drawable.bedroom)
        deviceName.toLowerCase(Locale.ROOT).contains("ruang makan") || deviceName.toLowerCase(Locale.ROOT).contains("dining room") -> painterResource(R.drawable.dining_room)
        deviceName.toLowerCase(Locale.ROOT).contains("ruang tamu") || deviceName.toLowerCase(Locale.ROOT).contains("living room") -> painterResource(R.drawable.living_room)
        deviceName.toLowerCase(Locale.ROOT).contains("ruang cuci") || deviceName.toLowerCase(Locale.ROOT).contains("wash room") -> painterResource(R.drawable.wash_room)
        else -> painterResource(R.drawable.home)
    }
}

@Composable
fun CustomCard(
    isOnline: Boolean,
    deviceName: String,
    title: String,
    navController: NavController,
    isClickable: Boolean = true
) {
    val painter = getDeviceIcon(deviceName)

    Card(
        modifier = Modifier
            .clickable(isClickable) { if (isClickable) navController.navigate("detail/$deviceName") }
            .padding(16.dp),
        shape = RoundedCornerShape(8.dp),
        border = BorderStroke(2.dp, Color.Black),
        colors = CardDefaults.cardColors(
            containerColor = Red50,
        ),
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                text = if (isOnline) "Online" else "Offline",
                fontWeight = FontWeight.Bold,
                color = if (isOnline) Color.Green else Color.Red,
                fontSize = 12.sp,
                modifier = Modifier.align(Alignment.Start)
            )
            Spacer(modifier = Modifier.height(8.dp))
            Image(
                painter = painter,
                contentDescription = null,
                modifier = Modifier
                    .size(70.dp)
                    .align(Alignment.CenterHorizontally)
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = title,
                color = Color.Black,
                fontSize = 16.sp,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
        }
    }
}
