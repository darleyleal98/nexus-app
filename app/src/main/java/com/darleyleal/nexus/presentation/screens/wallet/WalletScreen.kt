package com.darleyleal.nexus.presentation.screens.wallet

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun WalletScreen(modifier: Modifier = Modifier) {
    Scaffold(
        content = {
            Column {
                Text(text = "TELA DE CARTEIRA")
            }
        }
    )
}