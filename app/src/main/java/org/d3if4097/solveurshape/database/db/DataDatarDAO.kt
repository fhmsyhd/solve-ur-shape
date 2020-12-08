package org.d3if4097.solveurshape.database.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface DataDatarDAO {
    @Query("SELECT * FROM bangun_datar_db")
    fun getDataBangunDatar(): LiveData<List<DataDatarDB>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(bangunDatar: List<DataDatarDB>)
}