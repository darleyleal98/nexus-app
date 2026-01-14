package com.darleyleal.nexus.presentation.provider

import androidx.lifecycle.ViewModel
import com.darleyleal.nexus.presentation.screens.auth.AuthViewModel
import com.darleyleal.nexus.presentation.screens.home.HomeViewModel
import com.darleyleal.nexus.presentation.screens.investiments.InvestimentsViewModel
import com.darleyleal.nexus.presentation.screens.loans.LoansViewModel
import com.darleyleal.nexus.presentation.screens.login.LoginViewModel
import com.darleyleal.nexus.presentation.screens.profile.ProfileViewModel
import com.darleyleal.nexus.presentation.screens.wallet.WalletViewModel
import jakarta.inject.Inject

class ViewModelProvider @Inject constructor(
    authViewModel: AuthViewModel,
    homeViewModel: HomeViewModel,
    investimentsViewModel: InvestimentsViewModel,
    loansViewModel: LoansViewModel,
    loginViewModel: LoginViewModel,
    profileViewModel: ProfileViewModel,
    walletViewModel: WalletViewModel
) : ViewModel() {
    private val viewModels: Map<ViewModelKey, ViewModel> = mapOf(
        ViewModelKey.AUTH to authViewModel,
        ViewModelKey.HOME to homeViewModel,
        ViewModelKey.INVESTIMENTS to investimentsViewModel,
        ViewModelKey.LOANS to loansViewModel,
        ViewModelKey.LOGIN to loginViewModel,
        ViewModelKey.PROFILE to profileViewModel,
        ViewModelKey.WALLET to walletViewModel
    )

    fun getViewModel(key: ViewModelKey): ViewModel {
        return viewModels[key] ?: throw IllegalArgumentException("Unknown ViewModel key: $key")
    }
}