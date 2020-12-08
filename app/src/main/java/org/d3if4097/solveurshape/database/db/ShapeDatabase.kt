package org.d3if4097.solveurshape.database.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import org.d3if4097.solveurshape.utils.constant.SHAPE_DB

@Suppress("SpellCheckingInspection")
@Database(entities = [DataDatarDB   ::class],
    version = 1,
    exportSchema = false)
abstract class ShapeDatabase : RoomDatabase() {

    abstract val dataDatarDAO: DataDatarDAO

    companion object {
        @Volatile
        private var INSTANCE: ShapeDatabase? = null

        fun getInstance(context: Context): ShapeDatabase {
            synchronized(this) {
                var instance = INSTANCE

                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        ShapeDatabase::class.java,
                        SHAPE_DB
                    )
                        .fallbackToDestructiveMigration()
                        .build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}