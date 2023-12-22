package com.example.siaga

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.siaga.ui.AboutScreen
import com.example.siaga.ui.BottomNavItem
import com.example.siaga.ui.BottomNavigationBar
import com.example.siaga.ui.ChangePassword
import com.example.siaga.ui.DetailScreen
import com.example.siaga.ui.EditProfileScreen
import com.example.siaga.ui.HomeScreen
import com.example.siaga.ui.login.LoginScreen
import com.example.siaga.ui.ProfileScreen
import com.example.siaga.ui.RegisterScreen
import com.example.siaga.ui.setting.SettingScreen
import com.example.siaga.ui.setting.SettingsViewModel
import com.example.siaga.ui.theme.SIAGATheme

class MainActivity : ComponentActivity() {
    private val viewModel: SettingsViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.loadLanguagePreference(this)
        setContent {
            SIAGATheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    val navBackStackEntry by navController.currentBackStackEntryAsState()
                    val currentRoute = navBackStackEntry?.destination?.route

                    Scaffold(
                        bottomBar = {
                            if (currentRoute !in listOf("login", "about", "change_password", "setting", "register")) {
                                BottomNavigationBar(navController)
                            }
                        }
                    ) { innerPadding ->
                        NavHost(
                            navController,
                            "home",
                            Modifier.padding(innerPadding)
                        ) {
                            composable(BottomNavItem.Home.route) { HomeScreen(navController) }
                            composable(BottomNavItem.Add.route) {  }
                            composable(BottomNavItem.Profile.route) { ProfileScreen(navController) }
                            composable(BottomNavItem.Logout.route) { }
                            composable("detail/{deviceName}") { backStackEntry ->
                                val deviceName = backStackEntry.arguments?.getString("deviceName")
                                DetailScreen(deviceName)
                            }
                            composable("about") { AboutScreen(navController) }
                            composable("change_password") { ChangePassword(navController) }
                            composable("setting") { SettingScreen(navController) }
                            composable("edit_profile") { EditProfileScreen(navController) }
                            composable("login") { LoginScreen(navController) }
                            composable("register") { RegisterScreen(navController) }
                        }
                    }
                }
            }
        }
    }
}
