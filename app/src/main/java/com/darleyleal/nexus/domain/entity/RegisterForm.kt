package com.darleyleal.nexus.domain.entity

data class RegisterForm(
    val email: String = "",
    val password: String = "",
    val confirmPassword: String = ""
)