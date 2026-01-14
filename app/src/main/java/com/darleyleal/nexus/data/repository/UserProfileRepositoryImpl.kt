package com.darleyleal.nexus.data.repository

import android.util.Log
import com.darleyleal.nexus.data.dao.UserDao
import com.darleyleal.nexus.data.entity.UserProfileEntity
import com.darleyleal.nexus.domain.repository.UserProfileRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/***
 * Implementation of UserProfileRepository.
 */
class UserProfileRepositoryImpl @Inject constructor(private val dao: UserDao) : UserProfileRepository {
    /**
     * Creates a new user profile in the database.
     * @param user The user profile to be created.
     * */
    override suspend fun createUserProfile(user: UserProfileEntity) {
        Log.d("UserProfileRepository", "Inserting user in Room: $user")
        dao.insert(user)
    }

    /**
     * Updates an existing user profile in the database.
     * @param user The updated user profile.
     * */
    override suspend fun updateUserProfile(user: UserProfileEntity) {
        dao.update(user)
    }

    /**
     * Retrieves a user profile from the database by user ID.
     * @param userId The ID of the user profile to retrieve.
     */
    override fun getUserProfile(userId: Int): Flow<UserProfileEntity?> = dao.getUserById(userId)
}