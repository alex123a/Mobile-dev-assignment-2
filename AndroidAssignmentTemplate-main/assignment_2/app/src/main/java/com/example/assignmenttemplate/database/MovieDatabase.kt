package com.example.assignmenttemplate.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room.databaseBuilder
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import java.io.File

@Database(entities = arrayOf(Movie::class), version = 1)
@TypeConverters(CastTypeConverter::class)
abstract class MovieDatabase : RoomDatabase() {
    abstract fun movieDao(): MovieDao

    companion object {
        private var INSTANCE: MovieDatabase? = null

        fun getAppDatabase(context: Context): MovieDatabase? {
            if (INSTANCE == null) {
                INSTANCE = databaseBuilder(context.applicationContext, MovieDatabase::class.java, "TheMovieGuideDB")
                    .allowMainThreadQueries()
                    .build()
            }
            return INSTANCE
        }
    }
}