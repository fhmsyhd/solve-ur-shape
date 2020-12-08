@file:Suppress("SpellCheckingInspection")

package org.d3if4097.solveurshape.database.db

import androidx.room.Entity
import androidx.room.PrimaryKey
import org.d3if4097.solveurshape.utils.constant.BDATAR_DB

@Entity(tableName = BDATAR_DB)
data class DataDatarDB constructor (
    @PrimaryKey
    var id: Long,
    var shapeName: String,
    var shapeDescription: String,
    var rumusKeliling: String,
    var rumusLuas: String,
    var image: String
)
