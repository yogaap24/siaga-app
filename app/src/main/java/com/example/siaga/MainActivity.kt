package com.example.siaga

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.siaga.ui.AboutScreen
import com.example.siaga.ui.ChangePassword
import com.example.siaga.ui.EditProfileScreen
import com.example.siaga.ui.LoginScreen
import com.example.siaga.ui.ProfileScreen
import com.example.siaga.ui.RegisterScreen
import com.example.siaga.ui.SettingScreen
import com.example.siaga.ui.theme.SIAGATheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SIAGATheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    NavHost(navController = navController, startDestination = "profile") {
                        composable("about") { AboutScreen(navController) }
                        composable("change_password") { ChangePassword(navController) }
                        composable("setting") { SettingScreen(navController) }
                        composable("profile") { ProfileScreen(navController) }
                        composable("edit_profile") { EditProfileScreen(navController) }
                        composable("login") { LoginScreen(navController) }
                        composable("register") { RegisterScreen(navController) }
                    }
                }
            }
        }
    }
}

