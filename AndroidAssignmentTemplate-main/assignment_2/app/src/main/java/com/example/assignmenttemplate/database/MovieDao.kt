package com.example.assignmenttemplate.database

import androidx.room.*

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

    @Query("UPDATE Movie SET image_reference = :imageRef WHERE id = :movieID")
    fun updateImage(movieID: Int, imageRef: String)
}