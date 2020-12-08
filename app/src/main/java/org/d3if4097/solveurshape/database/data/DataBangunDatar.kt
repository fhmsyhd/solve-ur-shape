package org.d3if4097.solveurshape.database.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Suppress("SpellCheckingInspection")
@Parcelize
data class DataBangunDatar(
    var id: Long,
    var shapeName: String,
    var shapeDescription: String,
    var rumusKeliling: String,
    var rumusLuas: String,
    var image: String
) : Parcelable