package com.example.assignmenttemplate

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.assignmenttemplate.database.Movie

class MovieAdapter(private val data : ArrayList<Movie>) : RecyclerView.Adapter<MovieAdapter.ViewHolder>() {

    inner class ViewHolder(item : View): RecyclerView.ViewHolder(item){
        val movieImage: ImageView = item.findViewById(R.id.imageViewMovie)
        val movieID: TextView = item.findViewById(R.id.movieID)
        val movieTitle: TextView = item.findViewById(R.id.title)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.movie_view_holder, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        println("Any data?: " + data.size)
        println("Any data?: " + data.size)
        println("Any data?: " + data.size)
        println("Any data?: " + data.size)
        println("Any data?: " + data.size)
        println("Any data?: " + data.size)
        println("Any data?: " + data.size)
        println("Any data?: " + data.size)
        println("Any data?: " + data.size)
        println("Any data?: " + data.size)
        println("Any data?: " + data.size)
        holder.movieImage.setImageResource(data[position].image_reference)
        holder.movieID.text = position.toString()
        holder.movieTitle.text = data[position].title
    }

    override fun getItemCount(): Int {
        return data.size
    }
}