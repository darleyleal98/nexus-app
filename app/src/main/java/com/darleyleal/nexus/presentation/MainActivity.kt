package com.darleyleal.nexus.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.darleyleal.nexus.presentation.provider.ViewModelKey
import com.darleyleal.nexus.presentation.provider.ViewModelProvider
import com.darleyleal.nexus.presentation.screens.auth.AuthViewModel
import com.darleyleal.nexus.presentation.screens.home.HomeViewModel
import com.darleyleal.nexus.presentation.screens.investiments.InvestimentsViewModel
import com.darleyleal.nexus.presentation.screens.loans.LoansViewModel
import com.darleyleal.nexus.presentation.screens.login.LoginScreen
import com.darleyleal.nexus.presentation.screens.login.LoginViewModel
import com.darleyleal.nexus.presentation.screens.main.NexusApp
import com.darleyleal.nexus.presentation.screens.profile.ProfileViewModel
import com.darleyleal.nexus.presentation.screens.splash.SplashScreen
import com.darleyleal.nexus.presentation.screens.wallet.WalletViewModel
import com.darleyleal.nexus.presentation.theme.NexusTheme
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        auth = Firebase.auth

        val loginViewModel: LoginViewModel by viewModels()
        val authViewModel: AuthViewModel by viewModels()
        val homeViewModel: HomeViewModel by viewModels()
        val investimentsViewModel: InvestimentsViewModel by viewModels()
        val loansViewModel: LoansViewModel by viewModels()
        val profileViewModel: ProfileViewModel by viewModels()
        val walletViewModel: WalletViewModel by viewModels()

        val viewModelProvider = ViewModelProvider(
            loginViewModel = loginViewModel,
            authViewModel = authViewModel,
            homeViewModel = homeViewModel,
            investimentsViewModel = investimentsViewModel,
            loansViewModel = loansViewModel,
            profileViewModel = profileViewModel,
            walletViewModel = walletViewModel
        )

        setContent {
            NexusTheme {
                val authViewModel = viewModelProvider.getViewModel(ViewModelKey.AUTH) as AuthViewModel

                val isAuthenticated by authViewModel.isAuthenticated.collectAsState()
                val isLoading by authViewModel.isLoading.collectAsState()

                when {
                    isLoading -> SplashScreen()
                    isAuthenticated -> NexusApp(viewModelProvider = viewModelProvider)
                    else -> LoginScreen(viewModelProvider = viewModelProvider, onNavigateToMainScreen = {

                    })
                }
            }
        }
    }
}