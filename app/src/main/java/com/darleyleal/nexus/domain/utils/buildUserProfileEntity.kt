package com.darleyleal.nexus.domain.utils

import com.darleyleal.nexus.data.entity.UserProfileEntity

fun buildUserProfileEntity(
    name: String?,
    email: String?,
    imagePath: String?,
    biometricEnabled: Boolean,
    pinEnabled: Boolean
): UserProfileEntity = UserProfileEntity(
    name = name, imagePath = imagePath,
    email = email, biometricEnabled = biometricEnabled,
    pinEnabled = pinEnabled
)