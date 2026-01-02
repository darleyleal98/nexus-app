package com.darleyleal.nexus.presentation.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun NexusTitleAppBar(modifier: Modifier = Modifier, title: String) {
    Column(
        modifier = modifier.padding(top = 34.dp)
    ) {
        Text(
            modifier = modifier.fillMaxWidth(),
            text = title,
            style = MaterialTheme.typography.displayMedium,
            textAlign = TextAlign.Center
        )
    }
}