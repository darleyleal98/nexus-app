package com.darleyleal.nexus.presentation.screens.profile.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.darleyleal.nexus.domain.utils.validateIfFieldIsNotEmpty
import com.darleyleal.nexus.presentation.theme.DarkCyan50

@Composable
fun EditProfileForm(
    modifier: Modifier = Modifier,
    onSubmit: () -> Unit = {}
) {
    var name by rememberSaveable { mutableStateOf("") }
    var errorMessage by rememberSaveable { mutableStateOf("") }
    var isError by rememberSaveable { mutableStateOf(false) }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        OutlinedTextField(
            value = name,
            onValueChange = { input ->
                name = input
                isError = validateIfFieldIsNotEmpty(input)
            },
            label = { Text("Name") },
            supportingText = {
                if (isError) {
                    Text(
                        modifier = Modifier.fillMaxWidth(),
                        text = "Field is required",
                        color = MaterialTheme.colorScheme.error
                    )
                }
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
            singleLine = true,
            isError = isError,
            shape = CircleShape,
            modifier = Modifier
                .fillMaxWidth()
        )
        Button(
            modifier = Modifier
                .height(58.dp)
                .fillMaxWidth()
                .padding(horizontal = 62.dp),
            colors = ButtonDefaults.buttonColors(containerColor = DarkCyan50),
            onClick = {

            },
        ) {
            Text("Save", style = MaterialTheme.typography.headlineLarge, color = Color.White)
        }
    }
}