package com.darleyleal.nexus.presentation.screens.main

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.darleyleal.nexus.presentation.navigation.AppDestinations
import com.darleyleal.nexus.presentation.screens.home.HomeScreen
import com.darleyleal.nexus.presentation.screens.investiments.InvestimentScreen
import com.darleyleal.nexus.presentation.screens.loans.LoansScreen
import com.darleyleal.nexus.presentation.screens.profile.ProfileScreen
import com.darleyleal.nexus.presentation.screens.wallet.WalletScreen
import com.darleyleal.nexus.presentation.theme.Gunmetal

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MainScreen(
    modifier: Modifier = Modifier, innerPaddingValues: PaddingValues, currentDestination: AppDestinations
) {
    Scaffold(
        modifier = modifier.padding(innerPaddingValues),
        content = {
            when (currentDestination.ordinal) {
                0 -> HomeScreen()
                1 -> InvestimentScreen()
                2 -> LoansScreen()
                3 -> WalletScreen()
                4 -> ProfileScreen()
            }
        }
    )
}