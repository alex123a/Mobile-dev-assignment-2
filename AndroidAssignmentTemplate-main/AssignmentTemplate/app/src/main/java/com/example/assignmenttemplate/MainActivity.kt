package com.example.assignmenttemplate

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.assignmenttemplate.database.Movie
import com.example.assignmenttemplate.database.MovieDatabase
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/*
    TODO
    - Detailed page
    - Design
 */

class MainActivity : AppCompatActivity() {
    lateinit var movieDatabase : MovieDatabase
    lateinit var adapter: MovieAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        movieDatabase = MovieDatabase.getAppDatabase(this)!!

        fillDatabase()
        fillRecycleView()
    }

    fun fillDatabase() = runBlocking {
        launch {
            if (movieDatabase.movieDao().getAll().isEmpty()) {
                var movie1 = Movie(0, "Django Unchained", "2012", "Quentin Tarantino", arrayListOf("Jamie Foxx","Leonardo DiCaprio", "Christoph Waltz"), R.drawable.djangounchained)
                movieDatabase.movieDao().insert(movie1)

                var movie2 = Movie(0, "Shrek", "2001", "Andrew Adamson", arrayListOf("Mike Myers", "Eddie Murhpy", "Cameron Diaz"), R.drawable.shrek)
                movieDatabase.movieDao().insert(movie2)

                var movie3 = Movie(0, "Pulp Fiction", "1994", "Quentin Tarantino", arrayListOf("Uma Thurman", "Samuel L. Jackson", "John Travolta"), R.drawable.pulpfiction)
                movieDatabase.movieDao().insert(movie3)

                var movie4 = Movie(0, "Get Out", "2017", "Jordan Peele", arrayListOf("Daniel Kaluuya", "Allison Williams", "LaKeith Stanfield"), R.drawable.getout)
                movieDatabase.movieDao().insert(movie4)

                var movie5 = Movie(0, "Saving Private Ryan", "1998", "Steven Spielberg", arrayListOf("Tom Hanks", "Matt Damon", "Vin Diesel"), R.drawable.ryan)
                movieDatabase.movieDao().insert(movie5)

                var movie6 = Movie(0, "Gladiator", "2000", "Ridley Scott", arrayListOf("Russel Crowe", "Joaquin Phoenix", "Connie Nielsen"), R.drawable.gladiator)
                movieDatabase.movieDao().insert(movie6)
            }
        }
    }

    fun fillRecycleView() {
        var movieList : ArrayList<Movie> = movieDatabase.movieDao().getAll() as ArrayList<Movie>

        adapter = MovieAdapter(movieList)

        var recyclerView: RecyclerView = findViewById(R.id.movieView)
        recyclerView.setHasFixedSize(true)
        var layoutManager = StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL)
        //var layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = adapter
    }

    fun showDetailedMovie(view: View) {
        val movieID = view.findViewById<TextView>(R.id.movieID).text.toString()
        val intent = Intent(this@MainActivity, MovieListActivity::class.java).apply {
            putExtra("movie_ID", movieID)
        }
        startActivity(intent)
    }
}