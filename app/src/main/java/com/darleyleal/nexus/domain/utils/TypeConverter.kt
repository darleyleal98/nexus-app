package com.darleyleal.nexus.domain.utils

import androidx.room.TypeConverter

@TypeConverter
fun fromInt(value: Int): Boolean = value == 1

@TypeConverter
fun booleanToInt(value: Boolean): Int = if (value) 1 else 0