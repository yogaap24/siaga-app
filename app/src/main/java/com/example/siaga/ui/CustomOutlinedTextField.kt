package com.example.siaga.ui

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
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
import com.example.siaga.ui.theme.Gray30
import com.example.siaga.ui.theme.Red20
import com.example.siaga.ui.theme.White10
import com.example.siaga.ui.theme.White20

@Composable
fun CustomOutlinedTextField(
    value: String,
    onValueChange: (String) -> Unit,
    placeholder: String,
    headerText: String? = null,
    leadingIcon: @Composable (() -> Unit)? = null,
    isPassword: Boolean = false,
    isEnable: Boolean = true,
    validator: (String) -> String? = { null },
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        if (!headerText.isNullOrEmpty()) {
            Text(text = headerText, fontWeight = FontWeight.Black)
        }

        var passwordVisibility by remember { mutableStateOf(!isPassword) }
        var isEnable by remember { mutableStateOf(isEnable) }
        var isFocused by remember { mutableStateOf(false) }
        val errorMessage = remember(value) { if (isFocused) validator(value) else null }
        val isError = errorMessage != null

        OutlinedTextField(
            value = value,
            onValueChange = onValueChange,
            placeholder = { Text(placeholder) },
            leadingIcon = leadingIcon,
            shape = RoundedCornerShape(30),
            trailingIcon = if (isPassword) {
                { IconButton(onClick = { passwordVisibility = !passwordVisibility }) {
                    Icon(
                        painter = painterResource(if (passwordVisibility) R.drawable.show else R.drawable.hide),
                        contentDescription = if (passwordVisibility) "Show password" else "Hide password"
                    )
                } }
            } else null,
            visualTransformation = if (isPassword && !passwordVisibility) PasswordVisualTransformation() else VisualTransformation.None,
            isError = isError,
            enabled = isEnable,
            colors = if (!isEnable) {
                OutlinedTextFieldDefaults.colors(
                    disabledBorderColor = White20,
                    disabledContainerColor = White10,
                    disabledPlaceholderColor = Gray30,
                )
            } else {
                OutlinedTextFieldDefaults.colors(
                    unfocusedBorderColor = White20,
                    focusedBorderColor = White20,
                    unfocusedPlaceholderColor = Gray30,
                )
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp)
                .border(3.dp, if (isError) Red20 else White20, RoundedCornerShape(30))
                .onFocusChanged { isFocused = it.isFocused }
        )

        if (isError) {
            Text(text = errorMessage!!, color = Color.Red)
        }
    }
}



