package com.example.assignmenttemplate.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface MovieDao {
    @Query("SELECT * FROM Movie")
    fun getAll(): List<Movie>

    @Query("SELECT * FROM Movie WHERE :movieID = id")
    fun loadByID(movieID: Int): Movie

    @Insert
    fun insert(movie: Movie)

    @Delete
    fun delete(movie: Movie)

}