package com.example.tze100.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ProcessObject(
    @SerializedName("result") var result: Boolean?
): Parcelable