package com.example.siaga.ui

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.siaga.ui.theme.Red10

@Composable
fun CustomButton(
    onClick: () -> Unit,
    buttonText: String,
    fontSize: TextUnit = 14.sp,
    modifier: Modifier = Modifier
) {
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(Red10),
        modifier = modifier
            .width(120.dp)
            .height(50.dp)
    ) {
        Text(text = buttonText, fontSize = fontSize)
    }
}


