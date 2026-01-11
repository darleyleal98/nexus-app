package com.darleyleal.nexus.data.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "profile")
data class Profile(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val name: String,
    val profileImagePath: String?,
    val biometricEnabled: Boolean,
    val pinEnabled: Boolean
)