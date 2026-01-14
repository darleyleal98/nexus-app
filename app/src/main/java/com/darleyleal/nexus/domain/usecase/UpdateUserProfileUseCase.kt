package com.darleyleal.nexus.domain.usecase

import com.darleyleal.nexus.domain.repository.UserProfileRepository
import com.darleyleal.nexus.domain.utils.buildUserProfileEntity
import com.darleyleal.nexus.domain.utils.validateUserProfile
import javax.inject.Inject

/**
 * Use case to retrieve user profile data from local database.
 **/
class UpdateUserProfileUseCase @Inject constructor(private val repository: UserProfileRepository) {
    /**
     * Updates user profile data in local database.
     **/
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

        repository.updateUserProfile(
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