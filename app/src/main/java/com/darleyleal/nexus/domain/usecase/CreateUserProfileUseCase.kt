package com.darleyleal.nexus.domain.usecase

import android.util.Log
import com.darleyleal.nexus.domain.repository.UserProfileRepository
import com.darleyleal.nexus.domain.utils.buildUserProfileEntity
import com.darleyleal.nexus.domain.utils.validateUserProfile
import jakarta.inject.Inject

/**
 *Use case to save user profile data in locadatabase
 * */
class CreateUserProfileUseCase @Inject constructor(private val repository: UserProfileRepository) {

    /**
     * Saves user profile data in local database.
     * */
    suspend operator fun invoke(
        name: String?,
        email: String?,
        imagePath: String?,
        biometricEnabled: Boolean,
        pinEnabled: Boolean
    ) {

        validateUserProfile(
            name = name,
            email = email,
            imagePath = imagePath,
            biometricEnabled = biometricEnabled,
            pinEnabled = pinEnabled,
            strict = false
        )

        repository.createUserProfile(
            buildUserProfileEntity(
                name = name,
                email = email,
                imagePath = imagePath,
                biometricEnabled = biometricEnabled,
                pinEnabled = pinEnabled
            )
        )
    }
}