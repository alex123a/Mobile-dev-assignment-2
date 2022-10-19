package com.example.assignmenttemplate

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.assignmenttemplate.database.Movie
import com.example.assignmenttemplate.database.MovieDao
import com.example.assignmenttemplate.database.MovieDatabase

class MovieListActivity : AppCompatActivity() {
    lateinit var movieDatabase : MovieDatabase
    lateinit var adapter: MovieAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display_movies)

        movieDatabase = MovieDatabase.getAppDatabase(this)!!

        var movieList : ArrayList<Movie> = movieDatabase.movieDao().getAll() as ArrayList<Movie>

        adapter = MovieAdapter(movieList)

        var recyclerView: RecyclerView = findViewById(R.id.movieView)
        recyclerView.setHasFixedSize(true)
        var layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        //var layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = adapter
    }
}