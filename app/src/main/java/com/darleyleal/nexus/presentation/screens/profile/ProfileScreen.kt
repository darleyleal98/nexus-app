package com.darleyleal.nexus.presentation.screens.profile

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.darleyleal.nexus.R
import com.darleyleal.nexus.presentation.components.NexusTitleAppBar
import com.darleyleal.nexus.presentation.screens.profile.components.EditProfileForm
import com.darleyleal.nexus.presentation.screens.profile.components.ProfileAvatar
import com.darleyleal.nexus.presentation.screens.profile.components.ProfileSectionCards
import com.darleyleal.nexus.presentation.theme.RichBlack

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileScreen(modifier: Modifier = Modifier) {
    var showIsEditableBottomSheet by rememberSaveable { mutableStateOf(false) }
    val sheetState = rememberModalBottomSheetState(skipPartiallyExpanded = true)
    Scaffold(
        containerColor = RichBlack,
        topBar = {
            NexusTitleAppBar(title = stringResource(R.string.profile))
        },
        content = { innerPadding ->
            Box(
                modifier = modifier
                    .background(RichBlack)
                    .padding(
                        top = innerPadding.calculateTopPadding(),
                        bottom = innerPadding.calculateBottomPadding(),
                        start = 16.dp,
                        end = 16.dp
                    )
                    .fillMaxSize()
            ) {
                Column(modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
                    ProfileAvatar(isEditable = false)
                    Text(
                        modifier = Modifier.padding(top = 8.dp),
                        text = "Darley Leal",
                        style = MaterialTheme.typography.displaySmall
                    )
                    Spacer(
                        modifier = Modifier.padding(top = 12.dp)
                    )
                    OutlinedButton(
                        onClick = {
                            showIsEditableBottomSheet = !showIsEditableBottomSheet
                        }
                    ) {
                        Icon(imageVector = Icons.Default.Edit, contentDescription = null)
                        Spacer(modifier = Modifier.padding(start = 8.dp))
                        Text(text = "Edit profile", style = MaterialTheme.typography.headlineMedium)
                    }
                    Spacer(
                        modifier = Modifier.padding(top = 12.dp)
                    )
                    ProfileSectionCards()
                    if (showIsEditableBottomSheet) {
                        ModalBottomSheet(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(top = innerPadding.calculateTopPadding()),
                            onDismissRequest = { showIsEditableBottomSheet = false },
                            sheetState = sheetState,
                            containerColor = RichBlack
                        ) {
                            ProfileAvatar(isEditable = true)
                            EditProfileForm()
                        }
                    }
                }
            }
        }
    )
}