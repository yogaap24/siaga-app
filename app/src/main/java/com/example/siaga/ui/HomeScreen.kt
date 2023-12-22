package com.example.siaga.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import com.example.siaga.R

@Composable
fun HomeScreen(navController: NavController) {
    CustomCard(
        isOnline = true,
        deviceName = "Bedroom",
        title = stringResource(R.string.kamar_tidur_1),
        navController = navController
    )
}
