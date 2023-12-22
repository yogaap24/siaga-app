package com.example.siaga.ui

import androidx.annotation.StringRes
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.siaga.R
import com.example.siaga.ui.theme.Red10

sealed class BottomNavItem(val route: String, val iconId: Int, @StringRes val labelId: Int) {
    object Home : BottomNavItem("home", R.drawable.home, R.string.home)
    object Add : BottomNavItem("add", R.drawable.plus_square, R.string.add)
    object Profile : BottomNavItem("profile", R.drawable.profile, R.string.profile)
    object Logout : BottomNavItem("logout", R.drawable.logout, R.string.logout)

    companion object {
        val values = listOf(Home, Add, Profile, Logout)
    }
}

@Composable
fun BottomNavigationBar(navController: NavController) {
    val showDialog = remember { mutableStateOf(false) }
    NavigationBar(
        containerColor = Red10
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route

        BottomNavItem.values.forEach { item ->
            item?.let {
                val icon = painterResource(id = it.iconId)
                val label = stringResource(id = it.labelId)
                NavigationBarItem(
                    selected = currentRoute == it.route,
                    onClick = {
                        if (it.route == "add") {
                            showDialog.value = true
                        } else {
                            navController.navigate(it.route) {
                                popUpTo(navController.graph.startDestinationId)
                                launchSingleTop = true
                            }
                        }
                    },
                    icon = { Icon(icon, contentDescription = null) },
                    label = { Text(label) }
                )
            }
        }
    }

    AddDialog(showDialog)
}
