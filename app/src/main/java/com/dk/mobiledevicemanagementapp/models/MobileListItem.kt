package com.dk.mobiledevicemanagementapp.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class MobileListItem(
    val Currency: String,
    val Description: String,
    val Id: String,
    val OS: String,
    val Price: Int,
    val imageUrl: String,
    val isFavorite: Boolean,
    val name: String,
    val review: Float,
    val size: String,
    val status: String
): Parcelable