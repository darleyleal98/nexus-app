package com.darleyleal.nexus.presentation.screens.profile.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Fingerprint
import androidx.compose.material.icons.filled.Security
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.darleyleal.nexus.R
import com.darleyleal.nexus.domain.enums.SecurityMethod

@Composable
fun ProfileSectionCards(modifier: Modifier = Modifier) {
    var selectedMethod by rememberSaveable { mutableStateOf<SecurityMethod?>(null) }
    LazyColumn(modifier = modifier.fillMaxWidth()) {
        item {
            ProfileCardItem(
                icon = Icons.Filled.Security,
                title = stringResource(R.string.pin),
                onSwitchValueChange = { isChecked ->
                    selectedMethod = if (isChecked) SecurityMethod.PIN else null
                },
                checked = selectedMethod == SecurityMethod.PIN
            )
        }

        item {
            ProfileCardItem(
                icon = Icons.Filled.Fingerprint,
                title = stringResource(R.string.biometrics),
                onSwitchValueChange = { isChecked ->
                    selectedMethod = if (isChecked) SecurityMethod.BIOMETRICS else null
                },
                checked = selectedMethod == SecurityMethod.BIOMETRICS
            )
        }
    }
}