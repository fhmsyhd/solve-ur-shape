@file:Suppress("SpellCheckingInspection")

package org.d3if4097.solveurshape.utils

import org.d3if4097.solveurshape.database.data.DataBangunDatar
import org.d3if4097.solveurshape.database.db.DataDatarDB

fun List<DataBangunDatar>.convertToDatabaseModel(): List<DataDatarDB> {
    return map {
        DataDatarDB(
            id = it.id,
            shapeName = it.shapeName,
            shapeDescription = it.shapeDescription,
            rumusKeliling = it.rumusKeliling,
            rumusLuas = it.rumusLuas,
            image = it.image
        )
    }
}