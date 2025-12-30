package com.darleyleal.nexus.presentation.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.TrendingUp
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Payment
import androidx.compose.material.icons.filled.Wallet
import androidx.compose.ui.graphics.vector.ImageVector

enum class AppDestinations(
    val label: String,
    val icon: ImageVector,
) {
    HOME("Home", Icons.Default.Home),
    INVESTIMENT("Investment", Icons.AutoMirrored.Filled.TrendingUp),
    LOANS("Loans", Icons.Default.Payment),
    WALLET("Wallet", Icons.Default.Wallet),
    PROFILE("Profile", Icons.Default.AccountBox),
}