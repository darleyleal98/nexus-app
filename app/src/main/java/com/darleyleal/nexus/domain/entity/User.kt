package com.darleyleal.nexus.domain.entity

import androidx.room.ColumnInfo
import androidx.room.PrimaryKey

data class User(
    val id: Int = 0,
    val name: String? = null,
    val email: String? = null,
    val imagePath: String? = null,
    val biometricEnabled: Boolean,
    val pinEnabled: Boolean
)