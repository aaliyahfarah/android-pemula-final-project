package com.dicoding.mbtiapp

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Mbti(
    val name: String,
    val type: String,
    val generaldesc: String,
    val description: String,
    val people: String,
    val photo: Int
) : Parcelable
