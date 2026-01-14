package com.darleyleal.nexus.domain.utils

fun validateUserProfile(
    name: String?,
    email: String?,
    imagePath: String?,
    biometricEnabled: Boolean,
    pinEnabled: Boolean,
    strict: Boolean = true
) {
    require(!name.isNullOrBlank()) { "Name can't be empty" }

    if (strict) {
        require(!email.isNullOrBlank()) { "Email is required" }
        require(!imagePath.isNullOrBlank()) { "Image Path is required" }
    }
}