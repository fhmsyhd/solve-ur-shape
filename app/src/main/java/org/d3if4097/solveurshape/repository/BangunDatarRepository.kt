package org.d3if4097.solveurshape.repository

import android.util.Log
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.d3if4097.solveurshape.database.db.DataDatarDAO
import org.d3if4097.solveurshape.network.ApiShape
import org.d3if4097.solveurshape.utils.convertToDatabaseModel

@Suppress("SpellCheckingInspection")
class BangunDatarRepository (private val dataDatarDAO: DataDatarDAO) {

    val bangunDatar = dataDatarDAO.getDataBangunDatar()

    suspend fun refreshDataBangunDatar() {
        withContext(Dispatchers.IO) {
            val miwok = ApiShape.retrofitService.showList()
            Log.i("testingBangunDatar", miwok.toString())
            dataDatarDAO.insertAll(miwok.convertToDatabaseModel())
        }
    }
}