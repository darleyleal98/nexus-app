package com.darleyleal.nexus.presentation.screens.login

import android.annotation.SuppressLint
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.darleyleal.nexus.presentation.provider.ViewModelKey
import com.darleyleal.nexus.presentation.provider.ViewModelProvider
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun LoginScreen(
    viewModelProvider: ViewModelProvider,
    onNavigateToMainScreen: () -> Unit
) {
    val systemUiController = rememberSystemUiController()
    val context = LocalContext.current

    val loginViewModel = viewModelProvider.getViewModel(ViewModelKey.LOGIN) as LoginViewModel

    val isSuccessful by loginViewModel.isSuccessful.collectAsState()
    val isFailure by loginViewModel.isFailure.collectAsState()
    val errorMessage by loginViewModel.errorMessage.collectAsState()

    var email by rememberSaveable { mutableStateOf("") }
    var password by rememberSaveable { mutableStateOf("") }

    val snackbarHostState = remember { SnackbarHostState() }

    LaunchedEffect(Unit) {
        systemUiController.setSystemBarsColor(
            color = Color.Transparent,
            darkIcons = false
        )
    }

    LaunchedEffect(isSuccessful, isFailure) {
        when {
            isSuccessful -> onNavigateToMainScreen()
            isFailure -> snackbarHostState.showSnackbar(
                errorMessage ?: "Erro ao autenticar"
            )
        }
    }

    Scaffold(
        snackbarHost = { SnackbarHost(snackbarHostState) }
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    Brush.verticalGradient(
                        listOf(
                            Color(0xFF1E1E1E),
                            Color(0xFF0B0B0B)
                        )
                    )
                )
                .imePadding()
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 32.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Spacer(modifier = Modifier.height(96.dp))

                Text(
                    text = "neXus",
                    fontSize = 68.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = Color(0xFF4DE6E6)
                )

                Spacer(modifier = Modifier.height(64.dp))

                OutlinedTextField(
                    value = email,
                    onValueChange = { email = it },
                    label = {
                        Text(
                            text = "Email",
                            color = Color(0xFF9E9E9E)
                        )
                    },
                    shape = RoundedCornerShape(12.dp),
                    singleLine = true,
                    colors = TextFieldDefaults.colors(
                        focusedContainerColor = Color.Transparent,
                        unfocusedContainerColor = Color.Transparent,
                        focusedTextColor = Color.White,
                        unfocusedTextColor = Color.White,
                        focusedIndicatorColor = Color(0xFF4DE6E6),
                        unfocusedIndicatorColor = Color(0xFF9E9E9E),
                        cursorColor = Color(0xFF4DE6E6)
                    ),
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(modifier = Modifier.height(24.dp))

                OutlinedTextField(
                    value = password,
                    onValueChange = { password = it },
                    label = {
                        Text(
                            text = "Senha",
                            color = Color(0xFF9E9E9E)
                        )
                    },
                    shape = RoundedCornerShape(12.dp),
                    singleLine = true,
                    visualTransformation = PasswordVisualTransformation(),
                    colors = TextFieldDefaults.colors(
                        focusedContainerColor = Color.Transparent,
                        unfocusedContainerColor = Color.Transparent,
                        focusedTextColor = Color.White,
                        unfocusedTextColor = Color.White,
                        focusedIndicatorColor = Color(0xFF4DE6E6),
                        unfocusedIndicatorColor = Color(0xFF9E9E9E),
                        cursorColor = Color(0xFF4DE6E6)
                    ),
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(modifier = Modifier.height(36.dp))

                Button(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(56.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF4DE6E6)
                    ),
                    onClick = {
                        if (email.isNotBlank() && password.isNotBlank()) {
                            loginViewModel
                                .signInWithEmailAndPassword(email, password)
                        } else {
                            Toast.makeText(
                                context,
                                "Preencha todos os campos",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    }
                ) {
                    Text(
                        text = "Entrar",
                        color = Color.Black,
                        fontSize = 22.sp,
                        fontWeight = FontWeight.Medium
                    )
                }

                Spacer(modifier = Modifier.weight(1f))

                Row(
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Esqueci a senha",
                        color = Color(0xFF9E9E9E),
                        fontSize = 14.sp
                    )

                    Spacer(modifier = Modifier.width(16.dp))

                    Text(
                        text = "Criar uma conta",
                        color = Color(0xFF4DE6E6),
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Medium
                    )
                }

                Spacer(modifier = Modifier.height(24.dp))
            }
        }
    }
}