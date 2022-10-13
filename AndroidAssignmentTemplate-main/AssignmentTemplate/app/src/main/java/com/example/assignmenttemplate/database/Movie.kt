package com.example.assignmenttemplate.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

@Entity(tableName = "Movie")
data class Movie(
    @PrimaryKey (autoGenerate = true)
    @ColumnInfo(name = "id") val id: Int = 7,
    @ColumnInfo(name = "title") val title: String?,
    @ColumnInfo(name = "release_year") val releaseYear: String?,
    @ColumnInfo(name = "director") val director: String?,
    @ColumnInfo(name = "cast") val cast: ArrayList<String>,
    @ColumnInfo(name = "image_reference") val image_reference: String
)

class CastTypeConverter {
    @TypeConverter
    fun fromString(value: String) : ArrayList<String> {
        val listType = object: TypeToken<ArrayList<String>>(){}.type
        return Gson().fromJson(value, listType)
    }

    @TypeConverter
    fun fromArrayList(list: ArrayList<String?>): String {
        return Gson().toJson(list)
    }
}