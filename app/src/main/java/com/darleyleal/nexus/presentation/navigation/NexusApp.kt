package com.darleyleal.nexus.presentation.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.adaptive.navigationsuite.NavigationSuiteDefaults
import androidx.compose.material3.adaptive.navigationsuite.NavigationSuiteScaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.darleyleal.nexus.presentation.provider.ViewModelProvider
import com.darleyleal.nexus.presentation.screens.main.MainScreen
import com.darleyleal.nexus.presentation.theme.DarkCyan
import com.darleyleal.nexus.presentation.theme.RichBlack

@Composable
fun NexusApp(viewModelProvider: ViewModelProvider) {
    var currentDestination by rememberSaveable { mutableStateOf(AppDestinations.HOME) }
    val navigationItemColors = NavigationSuiteDefaults.itemColors(
        navigationBarItemColors = NavigationBarItemDefaults.colors(
            indicatorColor = DarkCyan,
            selectedIconColor = Color.White,
            selectedTextColor = Color.White,
            unselectedIconColor = Color.Gray,
            unselectedTextColor = Color.Gray
        )
    )

    NavigationSuiteScaffold(
        navigationSuiteColors = NavigationSuiteDefaults.colors(
            navigationBarContainerColor = RichBlack
        ),
        contentColor = Color.Red,
        navigationSuiteItems = {
            AppDestinations.entries.forEach {
                item(
                    icon = {
                        Icon(
                            imageVector = it.icon,
                            contentDescription = it.label
                        )
                    },
                    label = {
                        Text(it.label)
                    },
                    selected = it == currentDestination,
                    onClick = { currentDestination = it },
                    colors = navigationItemColors
                )
            }
        }
    ) {
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
            MainScreen(innerPaddingValues = innerPadding, currentDestination = currentDestination)
        }
    }
}