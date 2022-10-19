package com.example.assignmenttemplate

import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.assignmenttemplate.database.Movie
import com.example.assignmenttemplate.database.MovieDatabase

/*
    TODO
    - Use the technology with GroupList or whatever that was called to display the movies
    - Navigation techlogy by clicking on movie image and getting into a detailed movie page
    - Fix loading of database in MovieDatabase file
 */

class MainActivity : AppCompatActivity() {
    lateinit var movieDatabase : MovieDatabase

    private lateinit var numbers: EditText
    private lateinit var attributes: TextView
    private lateinit var picturePaths: ArrayList<Int>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        movieDatabase = MovieDatabase.getAppDatabase(this)!!
        numbers = findViewById<EditText>(R.id.editTextNumber)
        attributes = findViewById(R.id.Attributes)

        //Populates database if empty
        if(movieDatabase.movieDao().getAll().isEmpty()){
            // Log.i("DatabaseTest", "Ran Database Population")
            var movie1 = Movie(0, "Django Unchained", "2012", "Quentin Tarantino", arrayListOf("Jamie Foxx","Leonardo DiCaprio", "Christoph Waltz"), "djangounchained")
            movieDatabase.movieDao().insert(movie1)

            var movie2 = Movie(0, "Shrek", "2001", "Andrew Adamson", arrayListOf("Mike Myers", "Eddie Murhpy", "Cameron Diaz"), "shrek")
            movieDatabase.movieDao().insert(movie2)

            var movie3 = Movie(0, "Pulp Fiction", "1994", "Quentin Tarantino", arrayListOf("Uma Thurman", "Samuel L. Jackson", "John Travolta"), "pulpfiction")
            movieDatabase.movieDao().insert(movie3)

            var movie4 = Movie(0, "Get Out", "2017", "Jordan Peele", arrayListOf("Daniel Kaluuya", "Allison Williams", "LaKeith Stanfield"), "getout")
            movieDatabase.movieDao().insert(movie4)

            var movie5 = Movie(0, "Saving Private Ryan", "1998", "Steven Spielberg", arrayListOf("Tom Hanks", "Matt Damon", "Vin Diesel"), "ryan")
            movieDatabase.movieDao().insert(movie5)

            var movie6 = Movie(0, "Gladiator", "2000", "Ridley Scott", arrayListOf("Russel Crowe", "Joaquin Phoenix", "Connie Nielsen"), "gladiator")
            movieDatabase.movieDao().insert(movie6)
        }

    }

    fun showMovie(view: View) {
        var movie = movieDatabase.movieDao().loadByID(numbers.text.toString().toInt())
        if (movie != null) {
            attributes.text =
                "title: " + movie.title + "\nrelease_year: " + movie.director + "\nAdmin Status: " + movie.cast

            // Testing image below
            setContentView(R.layout.activity_main)
            val imageView = ImageView(this)
            imageView.layoutParams = LinearLayout.LayoutParams(300, 300) // value is in pixels
            println("movie ref: ${movie.image_reference}")
            val imageID =
                this.resources.getIdentifier(movie.image_reference, "drawable", this.packageName)
            println("reee: $imageID")
            imageView.setImageResource(imageID)
            val layout = findViewById<ConstraintLayout>(R.id.layout)
            println("Layout: $layout")
            layout?.addView(imageView)
        }
    }
}