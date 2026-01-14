package com.darleyleal.nexus.domain.entity

data class RegisterUiState(
    val form: RegisterForm = RegisterForm(),
    val result: RegisterResult? = null,
    val validationErrors: ValidationErrors = ValidationErrors()
) {
    val isFormValid: Boolean
        get() = validationErrors.isEmpty && form.email.isNotBlank() &&
                form.password.isNotBlank() && form.confirmPassword.isNotBlank()

    val canSubmit: Boolean
        get() = isFormValid && result !is RegisterResult.Loading
}

data class ValidationErrors(
    val emailError: String? = null,
    val passwordError: String? = null,
    val confirmPasswordError: String? = null
) {
    val isEmpty: Boolean
        get() = emailError == null && passwordError == null && confirmPasswordError == null
}