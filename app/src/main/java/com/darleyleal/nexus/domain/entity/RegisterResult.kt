package com.darleyleal.nexus.domain.entity

sealed class RegisterResult {
    object Success : RegisterResult()
    data class Error(val message: String) : RegisterResult()
    object Loading : RegisterResult()
}