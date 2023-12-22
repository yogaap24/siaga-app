package com.example.siaga.ui

import android.graphics.Bitmap
import android.graphics.ImageDecoder
import android.net.Uri
import android.util.Log
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.canhub.cropper.CropImage.CancelledResult.bitmap
import com.canhub.cropper.CropImage.CancelledResult.uriContent
import com.canhub.cropper.CropImageContract
import com.canhub.cropper.CropImageContractOptions
import com.canhub.cropper.CropImageOptions
import com.example.siaga.R
import com.example.siaga.ui.theme.Red20

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditProfileScreen(navController: NavController) {
    var email by remember { mutableStateOf("") }
    var username by remember { mutableStateOf("") }
    var phone by remember { mutableStateOf("") }
    val context = LocalContext.current
    var bitmap by remember { mutableStateOf<Bitmap?>(null)}
    var imageUri by remember { mutableStateOf<Uri?>(null)}

    val imageCropLauncher = rememberLauncherForActivityResult(CropImageContract()) { result ->
        if (result.isSuccessful) {
            imageUri = result.uriContent
        } else {
            val exception = result.error
            if (exception != null) {
                Toast.makeText(context, "Fail: ${exception.message}", Toast.LENGTH_LONG).show()
            }
        }
    }

    if (imageUri != null) {
        val source = ImageDecoder.createSource(context.contentResolver, imageUri!!)
        bitmap = ImageDecoder.decodeBitmap(source)
    }

    Scaffold(
        topBar = {
            TopAppBar(
                { Text(stringResource(R.string.ubah_profile)) },
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
                Box(
                    Modifier
                        .size(150.dp)
                        .clip(CircleShape)
                        .align(Alignment.CenterHorizontally)
                ) {
                    if (bitmap != null) {
                        Image(
                            bitmap = bitmap!!.asImageBitmap(),
                            contentDescription = "Profil",
                            contentScale = ContentScale.Crop,
                            modifier = Modifier
                                .size(150.dp)
                                .clip(CircleShape)
                        )
                    } else {
                        Image(
                            painterResource(R.drawable.icon),
                            contentDescription = "Logo",
                            modifier = Modifier
                                .size(150.dp)
                                .clip(CircleShape)
                        )
                    }

                    IconButton(
                        onClick = {
                            val cropOption = CropImageContractOptions(uriContent, CropImageOptions())
                            imageCropLauncher.launch(cropOption)
                        },
                        modifier = Modifier
                            .align(Alignment.BottomEnd)
                            .offset((-6).dp, (-6).dp)
                            .size(50.dp),
                        content = {
                            Icon(
                                painterResource(R.drawable.edit_square),
                                "Ubah",
                                Modifier.size(53.dp)
                            )
                        }
                    )
                }

                Spacer(Modifier.height(40.dp))

                CustomOutlinedTextField(
                    value = username,
                    onValueChange = { username = it },
                    placeholder = "JohnDoe",
                    headerText = stringResource(R.string.nama_pengguna),
                    leadingIcon = { Icon(painterResource(R.drawable.profile),"Profile icon") },
                    modifier = Modifier.fillMaxWidth(),
                    isEditable = true
                )

                Spacer(modifier = Modifier.height(16.dp))

                CustomOutlinedTextField(
                    value = phone,
                    onValueChange = { phone = it },
                    placeholder = "0800000000",
                    headerText = stringResource(R.string.telepon),
                    leadingIcon = { Icon(painterResource(R.drawable.call),"Call icon") },
                    modifier = Modifier.fillMaxWidth(),
                    isEditable = true
                )

                Spacer(modifier = Modifier.height(16.dp))

                CustomOutlinedTextField(
                    value = email,
                    onValueChange = { email = it },
                    placeholder = stringResource(R.string.contoh_mail_com),
                    headerText = stringResource(R.string.email),
                    leadingIcon = { Icon(painterResource(R.drawable.mail),"Email icon") },
                    modifier = Modifier.fillMaxWidth(),
                    isEditable = true
                )

                Spacer(Modifier.height(40.dp))

                CustomButton(
                    onClick = {},
                    buttonText = stringResource(R.string.simpan),
                )
            }
        }
    )
}

