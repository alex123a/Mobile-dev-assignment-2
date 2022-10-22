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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display_movies)

        movieDatabase = MovieDatabase.getAppDatabase(this)!!

        val movieID = intent.getStringExtra("movie_ID")
        if (movieID != null) {
            val movie = movieDatabase.movieDao().loadByID(movieID.toInt())

            val image: ImageView = this.findViewById(R.id.detailedMovieImage)
            image.setImageResource(movie.image_reference)

            val title: TextView = this.findViewById(R.id.detailedMovieTitle)
            title.text = "Title: " + movie.title

            val release: TextView = this.findViewById(R.id.detailedMovieReleaseYear)
            release.text = "Release year: " + movie.releaseYear

            val director: TextView = this.findViewById(R.id.detailedMovieDirector)
            director.text = "Director: " + movie.director

            val cast: TextView = this.findViewById(R.id.detailedMovieCast)
            val actors: ArrayList<String> = movie.cast
            var castText = "Cast: "
            for (actor in actors) {
                castText = "$castText$actor, "
            }
            cast.text = castText
        }
    }
}