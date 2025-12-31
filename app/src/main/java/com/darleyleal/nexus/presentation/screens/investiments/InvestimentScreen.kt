package com.darleyleal.nexus.presentation.screens.investiments

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.darleyleal.nexus.presentation.theme.RichBlack

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun InvestimentScreen(modifier: Modifier = Modifier) {
    Scaffold(
        containerColor = RichBlack,
        content = {
            Column {
                Text(text = "TELA DE INVESTIMENTOS")
            }
        }
    )
}