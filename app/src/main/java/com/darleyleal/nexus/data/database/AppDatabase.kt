package com.darleyleal.nexus.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.darleyleal.nexus.data.dao.UserDao
import com.darleyleal.nexus.data.entity.UserProfileEntity

@Database(
    entities = [UserProfileEntity::class],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
}