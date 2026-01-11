package com.darleyleal.nexus.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.darleyleal.nexus.data.models.Profile

@Database(
    entities = [Profile::class],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {}