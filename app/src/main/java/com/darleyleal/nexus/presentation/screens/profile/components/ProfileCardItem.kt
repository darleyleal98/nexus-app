package com.darleyleal.nexus.presentation.screens.profile.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import com.darleyleal.nexus.presentation.components.NexusSwitchToggle
import com.darleyleal.nexus.presentation.theme.DarkCyan

@Composable
fun ProfileCardItem(
    modifier: Modifier = Modifier,
    icon: ImageVector,
    title: String,
    onSwitchValueChange: (Boolean) -> Unit,
    checked: Boolean
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .height(100.dp),
        colors = CardDefaults.cardColors(containerColor = DarkCyan)
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(all = 16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(imageVector = icon, contentDescription = null, tint = Color.Cyan)
            Spacer(modifier = Modifier.padding(start = 16.dp))
            Text(text = title, color = Color.LightGray, style = MaterialTheme.typography.headlineLarge)
            Box(
                modifier = Modifier.fillMaxWidth(),
                contentAlignment = Alignment.BottomEnd
            ) {
                NexusSwitchToggle(
                    checked = checked,
                    onCheckedChange = onSwitchValueChange
                )
            }
        }
    }
    Spacer(modifier = Modifier.padding(bottom = 8.dp))
}