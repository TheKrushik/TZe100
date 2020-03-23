package com.example.tze100.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class IdObject(
    @SerializedName("id") var id: String?
): Parcelable