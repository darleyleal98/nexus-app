package com.darleyleal.nexus.presentation.screens.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.NotificationsNone
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.darleyleal.nexus.presentation.theme.RichBlack
import com.darleyleal.nexus.presentation.theme.TerciaryText

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
    Scaffold(
        containerColor = RichBlack,
        topBar = {
            TopAppBar(
                title = {
                    Column {
                        Text(text = "Good morning", style = MaterialTheme.typography.displaySmall, color = TerciaryText)
                        Text(text = "Darley Leal", style = MaterialTheme.typography.displaySmall)
                    }
                },
                actions = {
                    val iconSize = 28.dp

                    IconButton(onClick = {}) {
                        Icon(
                            imageVector = Icons.Filled.NotificationsNone, contentDescription = null,
                            modifier = modifier.size(iconSize)
                        )
                    }

                    Spacer(modifier = Modifier.padding(start = 8.dp))

                    IconButton(onClick = {}) {
                        Icon(
                            imageVector = Icons.Filled.Search, contentDescription = null,
                            modifier = modifier.size(iconSize)
                        )
                    }
                }
            )
        },
        content = { paddingValues ->
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = paddingValues.calculateTopPadding() + 32.dp, start = 16.dp, end = 16.dp)
            ) {
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(text = "Total budget", style = MaterialTheme.typography.displaySmall, color = TerciaryText)
                    Text(text = "R$ 4.350,00", style = MaterialTheme.typography.displayMedium)
                }
            }
        }
    )
}