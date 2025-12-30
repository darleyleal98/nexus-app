package com.darleyleal.nexus.presentation.screens.investiments

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun InvestimentScreen(modifier: Modifier = Modifier) {
    Scaffold(
        content = {
            Column {
                Text(text = "TELA DE INVESTIMENTOS")
            }
        }
    )
}