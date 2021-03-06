package com.example.Projet4A.presentation.details

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.Projet4A.R

import com.example.Projet4A.data.local.models.Movie
import com.example.Projet4A.services.Constants

import kotlinx.android.synthetic.main.row_similar_movie_layout.view.*

class SimilarMoviesAdapter(val context: Context, val list: MutableList<Movie>): RecyclerView.Adapter<SimilarMoviesAdapter.SimilarMoviesVH>() {

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): SimilarMoviesVH {
        return SimilarMoviesVH(LayoutInflater.from(parent.context).inflate(R.layout.row_similar_movie_layout, parent, false))
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: SimilarMoviesVH, position: Int) {
        val movie = list[position]
        holder.bind(movie)
    }

    class SimilarMoviesVH(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(movie: Movie) {
            itemView.title.text = movie.title
            Glide.with(itemView.context)
                .load(Constants.movieImagePrefix+"w500/"+movie.poster_path)
                .into(itemView.poster)
            itemView.setOnClickListener {
                val intent = Intent(itemView.context, MovieDetailActivity::class.java)
                intent.putExtra("addedTime", movie.addedTime)
                intent.putExtra("id", movie.id)
                intent.putExtra("poster", movie.poster_path)
                itemView.context.startActivity(intent)
            }
        }
    }
}
