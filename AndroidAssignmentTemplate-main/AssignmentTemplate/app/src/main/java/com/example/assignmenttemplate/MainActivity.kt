package com.example.assignmenttemplate

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.TextView
import com.example.assignmenttemplate.database.Movie
import com.example.assignmenttemplate.database.MovieDatabase

class MainActivity : AppCompatActivity() {
    lateinit var movieDatabase : MovieDatabase

    private lateinit var numbers: EditText
    private lateinit var attributes : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        movieDatabase = MovieDatabase.getAppDatabase(this)!!
        numbers = findViewById<EditText>(R.id.editTextNumber)
        attributes = findViewById(R.id.Attributes)

        //Populates database if empty
        if(movieDatabase.movieDao().getAll().isEmpty()){
            // Log.i("DatabaseTest", "Ran Database Population")
            var movie1 = Movie(0, "Django Unchained", "2012", "Quentin Tarantino", arrayListOf("Jamie Foxx","Leonardo DiCaprio", "Christoph Waltz"), "djangoUnchained.png")
            movieDatabase.movieDao().insert(movie1)

            var movie2 = Movie(0, "Shrek", "2001", "Andrew Adamson", arrayListOf("Mike Myers", "Eddie Murhpy", "Cameron Diaz"), "shrek.png")
            movieDatabase.movieDao().insert(movie2)

            var movie3 = Movie(0, "Pulp Fiction", "1994", "Quentin Tarantino", arrayListOf("Uma Thurman", "Samuel L. Jackson", "John Travolta"), "pulpfiction.png")
            movieDatabase.movieDao().insert(movie3)

            var movie4 = Movie(0, "Get Out", "2017", "Jordan Peele", arrayListOf("Daniel Kaluuya", "Allison Williams", "LaKeith Stanfield"), "getout.png")
            movieDatabase.movieDao().insert(movie4)

            var movie5 = Movie(0, "Saving Private Ryan", "1998", "Steven Spielberg", arrayListOf("Tom Hanks", "Matt Damon", "Vin Diesel"), "ryan.png")
            movieDatabase.movieDao().insert(movie5)

            var movie6 = Movie(0, "Gladiator", "2000", "Ridley Scott", arrayListOf("Russel Crowe", "Joaquin Phoenix", "Connie Nielsen"), "gladiator.png")
            movieDatabase.movieDao().insert(movie6)
        }

    }

    fun showMovie(view: View) {
        var movie = movieDatabase.movieDao().loadByID(numbers.text.toString().toInt())
        attributes.text = "title: " + movie.title + "\nrelease_year: " + movie.director + "\nAdmin Status: " + movie.cast
    }
}