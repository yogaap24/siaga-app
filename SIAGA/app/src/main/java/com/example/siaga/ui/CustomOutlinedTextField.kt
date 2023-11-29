package com.example.siaga.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.example.siaga.R

@Composable
fun CustomOutlinedTextField(
    value: String,
    onValueChange: (String) -> Unit,
    label: String,
    headerText: String? = null,
    leadingIcon: @Composable (() -> Unit)? = null,
    isPassword: Boolean = false,
    validator: (String) -> String? = { null },
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        if (!headerText.isNullOrEmpty()) {
            Text(text = headerText, fontWeight = FontWeight.Bold)
        }

        var passwordVisibility by remember { mutableStateOf(!isPassword) }
        var isFocused by remember { mutableStateOf(false) }
        val errorMessage = remember(value) { if (isFocused) validator(value) else null }
        val isError = errorMessage != null

        OutlinedTextField(
            value = value,
            onValueChange = onValueChange,
            label = { Text(label) },
            leadingIcon = leadingIcon,
            shape = RoundedCornerShape(30),
            trailingIcon = if (isPassword) {
                { IconButton(onClick = { passwordVisibility = !passwordVisibility }) {
                    Icon(
                        painter = painterResource(id = if (passwordVisibility) R.drawable.hide else R.drawable.show),
                        contentDescription = if (passwordVisibility) "Hide password" else "Show password"
                    )
                } }
            } else null,
            visualTransformation = if (isPassword && !passwordVisibility) PasswordVisualTransformation() else VisualTransformation.None,
            isError = isError,
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp)
                .onFocusChanged { isFocused = it.isFocused }
        )

        if (isError) {
            Text(text = errorMessage!!, color = Color.Red)
        }
    }
}



