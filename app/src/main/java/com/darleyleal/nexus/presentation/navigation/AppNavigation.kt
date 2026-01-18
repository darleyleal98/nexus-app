package com.darleyleal.nexus.presentation.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.darleyleal.nexus.presentation.provider.ViewModelProvider
import com.darleyleal.nexus.presentation.screens.login.LoginScreen
import com.darleyleal.nexus.presentation.screens.main.MainScreen

@Composable
fun AppNavigation(modifier: Modifier = Modifier, navController: NavHostController, viewModelProvider: ViewModelProvider, paddingValues: PaddingValues) {
    NavHost(startDestination = Routes.LOGIN.name, navController = navController) {
        composable(route = Routes.LOGIN.name) {
            LoginScreen(
                viewModelProvider = viewModelProvider,
                onNavigateToMainScreen = {
                    navController.navigate(Routes.MAIN.name)
                }
            )
        }

        composable(route = Routes.MAIN.name) {
            NexusApp(viewModelProvider)
        }
    }
}