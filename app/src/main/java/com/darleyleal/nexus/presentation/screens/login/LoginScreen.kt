package com.darleyleal.nexus.presentation.screens.login

import android.annotation.SuppressLint
import android.widget.Toast
import androidx.compose.foundation.Image
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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.OutlinedButton
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.darleyleal.nexus.R
import com.darleyleal.nexus.presentation.provider.ViewModelKey
import com.darleyleal.nexus.presentation.provider.ViewModelProvider
import com.darleyleal.nexus.presentation.theme.Cyan
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
                    fontSize = 78.sp,
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
                    shape = RoundedCornerShape(100.dp),
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

                Spacer(modifier = Modifier.height(16.dp))

                OutlinedTextField(
                    value = password,
                    onValueChange = { password = it },
                    label = {
                        Text(
                            text = "Password",
                            color = Color(0xFF9E9E9E)
                        )
                    },
                    shape = RoundedCornerShape(100.dp),
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

                Spacer(modifier = Modifier.height(24.dp))

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
                                "All the fields are required",
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

                Spacer(modifier = Modifier.height(32.dp))

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center,
                    modifier = Modifier.padding(horizontal = 8.dp)
                ) {
                    HorizontalDivider(
                        color = Cyan,
                        modifier = Modifier.weight(0.4f)
                    )

                    Row(
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Spacer(modifier = Modifier.width(16.dp))

                        Text(
                            text = "Or",
                            color = Color(0xFF4DE6E6),
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Medium
                        )

                        Spacer(modifier = Modifier.width(16.dp))
                    }

                    HorizontalDivider(
                        color = Color(0xFF4DE6E6),
                        modifier = Modifier.weight(0.4f)
                    )
                }

                Spacer(modifier = Modifier.height(32.dp))

                OutlinedButton(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(56.dp),
                    onClick = {

                    }
                ) {
                    Image(
                        painterResource(R.drawable.google),
                        contentDescription = null,
                        contentScale = ContentScale.Inside,
                        modifier = Modifier.size(28.dp)
                    )

                    Spacer(modifier = Modifier.padding(start = 16.dp))

                    Text(
                        text = "Continue with Google",
                        color = Cyan,
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
                        text = "Forgot password",
                        color = Color(0xFF9E9E9E),
                        fontSize = 14.sp
                    )

                    Spacer(modifier = Modifier.width(16.dp))

                    Text(
                        text = "Create account",
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